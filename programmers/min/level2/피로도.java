class Solution {
    
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        
        int n = dungeons.length;
        visited = new boolean[n];
        
        dfs(k, dungeons);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons){
        
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i])
                continue;
            if(k < dungeons[i][0])
                continue;
            
            visited[i] = true;
            k -= dungeons[i][1];

            dfs(k, dungeons);

            visited[i] = false;
            k += dungeons[i][1];
        }
        
        int cnt = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i])
                cnt++;
        }
        answer = Math.max(answer, cnt);
    }
}
