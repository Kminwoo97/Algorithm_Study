import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y + 1];
        int max = Integer.MAX_VALUE;
        
        for (int i = x + 1; i <= y; i++) {
            int ans1 = max;
            int ans2 = max;
            int ans3 = max;
            
            if ((i - n) >= x) {
                ans1 = dp[i - n];
            }
            
            if (i / 2 > 0 && i % 2 == 0 && (i / 2) >= x) {
                ans2 = dp[i / 2];
            }
            
            if (i / 3 > 0 && i % 3 == 0 && (i / 3) >= x) {
                ans3 = dp[i / 3];
            }
            
            dp[i] = Math.min(Math.min(ans1, ans2), ans3);
            
            if (dp[i] != max) {
                dp[i]++;
            }
        }
        
        if (dp[y] == max) {
            dp[y] = -1;
        }
        
        return answer = dp[y];
    }
}
