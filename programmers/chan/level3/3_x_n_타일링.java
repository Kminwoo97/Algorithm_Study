class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n + 1];
        
        if (n >= 2) {
            dp[2] = 3;
        }
        
        if (n >= 4) {
            dp[4] = 11;
        }
        
        for (int i = 6; i <= n; i += 2) {
            for (int j = 2; j < i; j += 2) {
                if (j == 2) {
                    dp[i] += 3 * dp[i - j];
                } else {
                    dp[i] += 2 * dp[i - j];
                }
            }
            
            dp[i] += 2;
            dp[i] %= 1000000007;
        }
        
        return answer = (int) dp[n];
    }
}
