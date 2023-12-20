class Solution
{
    static int max = 0;
    
    public int solution(int [][]board)
    {
        int answer = 1234;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    find(board, new int[]{i, j}, 1);
                }
            }
        }

        return answer = max * max;
    }
    
    public void find(int[][] board, int[] cur, int count) {
        max = Math.max(max, count);
        
        int[] next = {cur[0] + 1, cur[1] + 1};
        
        if (next[0] >= 0 && next[0] < board.length &&
            next[1] >= 0 && next[1] < board[0].length &&
            board[next[0]][next[1]] == 1) {
            
            boolean flag = true;
            
            for (int i = cur[0]; i < next[0]; i++) {
                if (board[i][next[1]] != 1) {
                    flag = false;
                    break;
                }
            }
            
            for (int i = cur[1]; i < next[1]; i++) {
                if (board[next[0]][i] != 1) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                find(board, next, count + 1);
            } else {
                return;
            }
        }
    }
}
