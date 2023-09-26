import java.util.*;

class Solution {
    boolean[] visited;
    int[][] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new int[n+1][n+1];
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1]; 
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        for(int i=1; i<graph.length; i++){
            for(int j=i; j<graph.length; j++){
                if(graph[i][j] == 1){
                    //연결 끊기
                    graph[i][j] = 0;
                    graph[j][i] = 0;
                    
                    //i노드에서 완전탐색
                    visited = new boolean[n+1];
                    int a = dfs(i);
                    
                    //j노드에서 완전탐색
                    visited = new boolean[n+1];
                    int b = dfs(j);
                    
                    answer = Math.min(answer, Math.abs(a-b));
                    
                    //다시 연결
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        
        return answer;
    }
    
    public int dfs(int x){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;
        q.offer(x);
        visited[x] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int i=1; i<graph.length; i++){
                if(graph[node][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
