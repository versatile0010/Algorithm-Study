class Solution {
    static int [][] graph;
    static boolean [] visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        graph = new int[n+1][n+1];
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            graph[a][b] = graph[b][a] = 1;
        }
        
        dfs(1, n);
        
        return answer;
    }
    
    static int dfs(int v, int n){
        visited[v] = true;
        int child = 1;
        for(int i = 1 ; i <= n; i++){
            if(!visited[i] && graph[v][i] == 1){
                child += dfs(i, n);
            }
        }
        answer = Math.min(answer, Math.abs(child - (n - child)));
        return child;
    }
}
