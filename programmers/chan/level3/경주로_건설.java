import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        int answer = 0;
        int[][] dp = new int[board.length][board.length];
        
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = 0;
        bfs(board, dp, 0, 0, 0, -1);
        
        return answer = min;
    }
    
    public void bfs(int[][] board, int[][] dp, int x, int y, int cost, int preMove) {
        Queue<int[]> queue = new LinkedList<>();
        int[] moveX = {0, 0, -1, 1}; // 상하좌우
        int[] moveY = {-1, 1, 0, 0};
        
        queue.offer(new int[]{y, x, cost, -1});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == board.length - 1 && cur[1] == board.length - 1) {
                min = Math.min(min, cur[2]);
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur[1] + moveX[i];
                int nextY = cur[0] + moveY[i];
                int extraCost = 100; 
                
                if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board.length && 
                    board[nextY][nextX] == 0 && 
                    dp[nextY][nextX] >= cur[2] + 100) {
                    
                    if (cur[3] != -1 && cur[3] != i) {
                        extraCost += 500;
                    }
                    
                    dp[nextY][nextX] = Math.min(dp[nextY][nextX], cur[2] + extraCost);
                    queue.offer(new int[]{nextY, nextX, cur[2] + extraCost, i});
                }
            }
        }
    }
}
