import java.util.*;

class Solution {
    static int[][] dp;
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        dp = new int[sales.length + 1][2];
        List<Integer>[] list = new ArrayList[sales.length + 1];
        
        for (int i = 1; i <= sales.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < links.length; i++) {
            list[links[i][0]].add(links[i][1]);
        }
        
        dfs(sales, list, 1);
        
        return answer = Math.min(dp[1][0], dp[1][1]);
    }
    
    public void dfs(int[] sales, List<Integer>[] list, int cur) {
        dp[cur][0] = 0;
        dp[cur][1] = sales[cur - 1];
        
        if (list[cur].size() == 0) {
            return;
        }
                
        int extra = Integer.MAX_VALUE;
        
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            
            dfs(sales, list, next);
            
            if(dp[next][0] < dp[next][1]) {
				dp[cur][0] += dp[next][0];
				dp[cur][1] += dp[next][0];
				
				extra = Math.min(extra, dp[next][1] - dp[next][0]);
			} else {
				dp[cur][0] += dp[next][1];
				dp[cur][1] += dp[next][1];
				
				extra = 0;
			}
		}
		
		dp[cur][0] += extra;
    }
}
