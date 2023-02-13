import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku = new int[9][9];
    static boolean[][] rowCheck = new boolean[9][10];
    static boolean[][] colCheck = new boolean[9][10];
    static boolean[][] boxCheck = new boolean[9][10];
    static boolean isitdone;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void dfs(int k) throws IOException {
        if(isitdone) return;
        int x_pos = k % 9;
        int y_pos = k / 9;
        if (k == 81) {
            isitdone=true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        if (sudoku[y_pos][x_pos] == 0) {
            for (int t = 1; t <= 9; t++) {
                if(rowCheck[y_pos][t]==false && colCheck[x_pos][t]==false && boxCheck[(y_pos / 3) * 3 + x_pos / 3][t]==false){
                    rowCheck[y_pos][t] = true;
                    colCheck[x_pos][t] = true;
                    boxCheck[(y_pos / 3) * 3 + x_pos / 3][t] = true;
                    sudoku[y_pos][x_pos] = t;
                    dfs(k + 1);
                    sudoku[y_pos][x_pos] = 0;
                    rowCheck[y_pos][t] = false;
                    colCheck[x_pos][t] = false;
                    boxCheck[(y_pos / 3) * 3 + x_pos / 3][t] = false;
                }
            }
        } else dfs(k+1);
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;

        for (int i = 0; i < 9; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(stk.nextToken());
                rowCheck[i][sudoku[i][j]] = true;
                colCheck[j][sudoku[i][j]] = true;
                boxCheck[(i / 3) * 3 + j / 3][sudoku[i][j]] = true;
            }
        }

        dfs(0);


    }
}
