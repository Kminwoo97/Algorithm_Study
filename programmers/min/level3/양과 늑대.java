class Solution {
    
    int answer;
    
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        
        dfs(0, new boolean[n], info, edges, 0, 0);
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[] info, int[][] edges, int sheep, int wolf){
        visited[node] = true;
        
        if(info[node] == 0){
            sheep++;
            
            if(sheep > wolf)
                answer = Math.max(answer, sheep);
        }else{
            wolf++;
        }
        
        if(sheep <= wolf)
            return;
        
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            
            if(visited[a] == true && visited[b] == false){
                boolean[] next_visited = visited.clone(); 
                dfs(b, next_visited, info, edges, sheep, wolf);
            }
        }
    }
}
