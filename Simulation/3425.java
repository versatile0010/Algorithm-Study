import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<String> list;
    static gostack go;
    static int ans;
    static boolean overflow;
    static boolean zerodiv;
    public static void main(String[] args) throws IOException {
        go = new gostack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList<>();

        while(true) {
            list.clear();
            String task = br.readLine(); // 명령어를 한 줄씩 입력받는다
            if(task.equals("QUIT")) {
                // QUIT 명령어이면 프로그렘을 아예 종료
                //System.out.println("bye");
                return;
            }

            while(!task.equals("END")) {
                // END 를 받을 때 까지 계속 입력받는다.

                String[] splited = task.split(" ");
                if(splited.length==1) {
                    // NUM 이 아닌 다른 명령어 인 것
                    list.add(splited[0]);
                } else {
                    // NUM 을 받은 것임
                    list.add(splited[0]);
                    list.add(splited[1]); // 숫자까지 입력받음
                }
                task = br.readLine();
            }
            // 이제 명령어를 다 받은 것임


            int n = Integer.parseInt(br.readLine());
            long [] vals = new long[n];
            for(int i = 0 ; i < n ; i++) {
                vals[i] = Long.parseLong(br.readLine());
            } // 수를 입력받음

            for(int i = 0 ; i < n ; i ++) {
                go.clear();
                overflow=false;
                zerodiv=false;
                go.num(vals[i]);
                if(run()) {
                    if(overflow||zerodiv) {
                        System.out.println("ERROR");
                    }
                    else System.out.println(go.peek());
                } else {
                    System.out.println("ERROR");
                }
            }
            System.out.println();
            br.readLine();
        }
    }

    static boolean run() {
        boolean num_flag = false;
        for(int i = 0 ; i < list.size(); i++) {
            // 저장된 명령어 개수만큼

            String task = list.get(i);

            if(num_flag==true) {
                long x = Long.parseLong(task);
                go.num(x);
                num_flag=false;
            }

            if(task.equals("NUM")){
                num_flag=true;
            } else if(task.equals("POP")) {
                if(go.size()==0) {
                    // 비어있으면
                    return false; // 오류
                }
                go.pop();
            } else if(task.equals("INV")) {
                if(go.size()==0) {
                    // 비어있으면
                    return false; // 오류
                }
                go.inv();
            } else if(task.equals("DUP")) {
                if(go.size()==0) {
                    // 비어있으면
                    return false; // 오류
                }
                go.dup();
            } else if(task.equals("SWP")) {
                if(go.size()<2) {
                    // 2개보다 작으면
                    return false; // 오류
                }
                go.swp();
            } else if(task.equals("ADD")) {
                if(go.size()<2) {
                    // 2개보다 작으면
                    return false; // 오류
                }
                go.add();
            } else if(task.equals("SUB")) {
                if(go.size()<2) {
                    // 2개보다 작으면
                    return false; // 오류
                }
                go.sub();
            } else if(task.equals("MUL")) {
                if(go.size()<2) {
                    // 2개보다 작으면
                    return false; // 오류
                }
                go.mul();
            } else if(task.equals("DIV")) {
                if(go.size()<2) {
                    // 2개보다 작으면
                    return false; // 오류
                }
                go.div();
            } else if(task.equals("MOD")) {
                if(go.size()<2) {
                    // 2개보다 작으면
                    return false; // 오류
                }
                go.mod();
            }
        }
        if(go.size()==1)
            return true;
        else return false;
    }
    static class gostack{
        Stack<Long> st = new Stack<>();

        public void gostack() {
        }

        public long size() {
            return st.size();
        }

        public void clear() {
            st.clear();
        }

        public void num(long x) {
            // NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 10^9)
            st.add(x);
        }
        public void pop() {
            //POP: 스택 가장 위의 숫자를 제거한다.
            long t = st.peek();
            st.pop();
        }
        public void inv() {
            // INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
            long t = st.peek();
            st.pop(); // 일단 제거
            t = t*-1; // 부호 변환
            st.add(t); // 바뀐 부호로 저장
        }
        public void dup() {
            // DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
            long t= st.peek();
            st.add(t); // 하나 더 저장
        }
        public void swp() {
            // SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
            long first = st.pop();
            long second = st.pop();

            st.add(first);
            st.add(second);
        }
        public void add() {
            // ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
            long first = st.pop();
            long second = st.pop();
            // first + second
            if(Math.abs(first+second) > 1000000000)
                overflow = true;
            st.add(first+second);
        }
        public void sub() {
            // SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
            long first = st.pop();
            long second = st.pop();
            // second - first
            if(Math.abs(second-first)> 1000000000)
                overflow = true;
            st.add(second-first);
        }
        public void mul() {
            //MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
            long first = st.pop();
            long second = st.pop();
            if(first*second > 1000000000)
                overflow = true;
            st.add(first*second);
        }
        public void div() {
            // DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다.
            // 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
            long first = st.pop();
            long second = st.pop();

            if(first==0) {
                zerodiv=true;
                return;
            }
            long t = Math.abs(second)/Math.abs(first);
            // 부호 판단
            if(t > 1000000000)
                overflow = true;

            if(first*second<0/*음수가 한 개이면*/) {
                // 몫의 부호가 음수임
                st.add(-t);
            }
            else {
                st.add(t);
            }
        }
        public void mod() {
            // MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다.
            // 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
            long first = st.pop();
            long second = st.pop();
            if(first==0) {
                zerodiv=true;
                return;
            }
            long t = Math.abs(second)%Math.abs(first);
            if(t > 1000000000)
                overflow = true;

            // 나머지의 부호는 second 의 부호에 따라서 결정된다.
            if(second<0) {
                // second 가 음수이면
                st.add(-t);
            } else {
                // second 가 양수이면
                st.add(t);
            }
        }
        public long peek() {
            if(!st.isEmpty())
                return st.peek();
            else return -1;
        }
    }
}
