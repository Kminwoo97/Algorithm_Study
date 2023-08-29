class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
    
        //초기화 - 집, 물에 잠긴 곳
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        for(int[] puddle : puddles){
            int x = puddle[1];
            int y = puddle[0];
            
            dp[x][y] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                
                if(dp[i][j] == -1)
                    continue;
                
                //위에서 오는 경우 + 왼쪽에서 오는 경우
                if(dp[i][j-1] != -1)
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % 1000000007;
                if(dp[i-1][j] != -1){
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1000000007;
                }
            }
        }
        
        answer = dp[n][m];
        return answer;
    }
}
