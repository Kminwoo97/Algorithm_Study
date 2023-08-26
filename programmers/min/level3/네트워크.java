import java.util.*;

class Solution {
    boolean[] visited = new boolean[200];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        //그래프 초기화
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        
        //그래프 연결
        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                if(i != j && computers[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        //탐색
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, graph);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int i, ArrayList<ArrayList<Integer>> graph){
        ArrayList<Integer> edges = graph.get(i);
        for(int edge : edges){
            if(!visited[edge]){
                visited[edge] = true;
                dfs(edge, graph);
            }
        }
    }
}
