import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class NODE{
        int x, y;
        NODE(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int [][] graph;
    static int [][] safe_map;
    static int [][] bfs_map;
    static int row;
    static int col;
    static int ans = Integer.MIN_VALUE;

    static int dx [] = {0,0,-1,1};
    static int dy [] = {-1,1,0,0};

    public static void copy(int [][] dst, int [][] src){
        for(int i = 0 ; i < row ;i++){
            for(int j = 0 ; j < col ; j++){
                dst[i][j] = src[i][j];
            }
        }
    }

    public static void bfs(){
        Queue<NODE>q = new LinkedList<NODE>();
        copy(bfs_map, safe_map);
        for(int i = 0 ; i < row; i++){
            for(int j = 0 ; j < col; j++){
                if(safe_map[i][j] == 2){
                 q.add(new NODE(j,i)); // x, y
                }
            }
        }

        while(!q.isEmpty()){
            NODE cur = q.poll();
            for(int dir = 0 ; dir< 4; dir ++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx<0||nx>=col||ny<0||ny>=row) continue;
                if(bfs_map[ny][nx]==1) continue;
                if(bfs_map[ny][nx]>0) continue;
                bfs_map[ny][nx]=2;
                q.add(new NODE(nx, ny));
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < row; i++){
            for(int j  = 0 ; j < col; j++){
                if(bfs_map[i][j]==0)
                    cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }

    public static void dfs(int cnt){
        if(cnt==3){
            bfs();
            return;
        }
        else{
            for(int i = 0 ; i < row; i++){
                for(int j = 0 ; j < col; j++){
                    if(safe_map[i][j]==0){
                        safe_map[i][j]=1;
                        dfs(cnt+1);
                        safe_map[i][j]=0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());

        graph = new int[row][col];
        safe_map = new int[row][col];
        bfs_map = new int[row][col];

        for(int i = 0 ; i < row; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < col; j++){
                graph[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i  = 0; i < row; i++){
            for(int j = 0 ; j < col ; j++){
                if(graph[i][j] ==0){
                    copy(safe_map, graph);
                    safe_map[i][j] = 1;
                    dfs(1);
                    safe_map[i][j] = 0;
                }
            }
        }
        System.out.println(ans);
    }
}
