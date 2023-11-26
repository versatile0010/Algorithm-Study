import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean [] visited;
    static int answer;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        for(int i =1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < wires.length; i++){
            int st = wires[i][0];
            int end = wires[i][1];
            min = Math.min(
                Math.abs(bfs(st, end, n)-bfs(end, st, n)), min
            );   
        }
    
        answer = min;
        return answer;
    }
    
    static int bfs(int st, int end, int n){
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];
    
        q.offer(st);
        visited[st] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int cur : graph[now]){
                if(cur != end && !visited[cur]){
                    cnt++;
                    q.offer(cur);
                    visited[cur] = true;
                }
            }
        }
        return cnt;
    }
}
