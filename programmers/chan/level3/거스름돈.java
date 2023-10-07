import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[][] dp = new int[money.length][n + 1];
                
        Arrays.sort(money);
        
        for (int i = 0; i <= n; i++) {
            if (i % money[0] == 0) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        
        for (int i = 1; i < money.length; i++) {
            for (int j = 0; j <= n; j++) {
                
                if (j >= money[i]) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i]]) % 1000000007;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return answer = dp[money.length - 1][n];
    }
}
