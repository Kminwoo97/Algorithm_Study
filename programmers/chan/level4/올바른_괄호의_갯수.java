class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // 빈 문자열도 하나의 괄호 문자열로 취급

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
