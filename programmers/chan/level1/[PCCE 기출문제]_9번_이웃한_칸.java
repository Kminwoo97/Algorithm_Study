class Solution {
    static int[] moveX = {0, 0, -1, 1}; // 상하좌우
    static int[] moveY = {-1, 1, 0, 0}; // 상하좌우
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        return answer = bfs(board, h, w);
    }
    
    public int bfs(String[][] board, int y, int x) {
        int[] cur = {y, x};
        String color = board[y][x];
        int result = 0;
                    
        for (int i = 0; i < 4; i++) {
            int nextY = cur[0] + moveY[i];
            int nextX = cur[1] + moveX[i];
                
            if (nextY >= 0 && nextY < board.length &&
                nextX >= 0 && nextX < board[0].length &&
                board[nextY][nextX].equals(color)) {
                
                result++;
            }
        }
        
        return result;
    }
}
