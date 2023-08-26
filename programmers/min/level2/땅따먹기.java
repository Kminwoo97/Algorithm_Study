class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        
        //dp 초기화
        int[][] dp = new int[n][4];
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }
        
        //dp[i][j]의 값은 dp[i][k]에서 가장 큰 수를 골라서 더한다.
        for(int i=1; i<n; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    if(j == k)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
                }
            }
        }
        
        for(int i=0; i<4; i++){
            answer = Math.max(dp[n-1][i], answer);
        }

        return answer;
    }
}
