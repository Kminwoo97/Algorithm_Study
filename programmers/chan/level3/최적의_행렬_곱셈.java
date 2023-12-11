import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int[][] dp = new int[matrix_sizes.length][matrix_sizes.length];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length - i; j++) {
                int start = j;
                int end = j + i;
                
                if (start == end) {
                    continue;
                }
                
                dp[start][end] = Integer.MAX_VALUE;
                
                for (int k = start; k < end; k++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end] + matrix_sizes[start][0] * matrix_sizes[k][1] * matrix_sizes[end][1]);
                }
            }
        }
        
        return answer = dp[0][dp.length - 1];
    }
}
