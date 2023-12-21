import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;
        int max = 0;
        int[][] dp = new int[board.length][board[0].length];
        
        if (board.length < 2 || board[0].length < 2) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        max = 1;
                    }
                }
            }
        }
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    // 왼, 위, 대각선 값 확인
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    
                    if (dp[i][j] == 1) {
                        if (board[i][j - 1] == 1 && board[i - 1][j - 1] == 1 && board[i - 1][j] == 1) {
                            dp[i][j] = 2;
                        }
                    }
                    
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return answer = max * max;
    }
}
