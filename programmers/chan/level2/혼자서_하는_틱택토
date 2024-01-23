class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int oCount = 0;
        int xCount = 0;
        int dotCount = 0;
        boolean flag = true;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    oCount++;
                } else if (board[i].charAt(j) == 'X') {
                    xCount++;
                } else {
                    dotCount++;
                }
            }
        }
        
        // x가 o보다 많은 경우
        if (oCount < xCount) {
            flag = false; 
        } else if (oCount - xCount > 1) {
            // o와 x갯수가 1이상 차이날 경우
            flag = false;
        }
        
        if (flag) {
            answer = 1;
            
            if (oCount >= 3 && xCount >= 3) {
                boolean oWin = false;
                boolean xWin = false;
                
                // 3개 연속인지 확인
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!oWin) {
                            oWin = isWin(board, 'O', i, j);
                        }
                        
                        if (!xWin) {
                            xWin = isWin(board, 'X', i, j);
                        }
                    }
                }
                                
                // 둘 다 이긴 경우
                if (oWin && xWin) {
                    answer = 0;
                } else if (oWin && oCount != xCount + 1) {
                    // O가 이긴 경우 - O가 하나 더 많아야 함
                    answer = 0;
                } else if (xWin && oCount != xCount) {
                    // X가 이긴 경우 - O와 갯수 같아야 함
                    answer = 0;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isWin(String[] board, char ch, int i, int j) {
        boolean result = false;
        int row = 0;
        int col = 0;
        int diag = 0;
        int reDiag = 0;

        for (int k = 0; k < 3; k++) {
            // 가로
            if (j == 0 && board[i].charAt(j + k) == ch) {
                row++;
            }

            // 세로
            if (i == 0 && board[i + k].charAt(j) == ch) {
                col++;
            }

            // 대각선
            if (i == 0 && j == 0 && board[i + k].charAt(j + k) == ch) {
                diag++;
            }

            // 역대각선
            if (i == 0 && j == 2 && board[i + k].charAt(j - k) == ch) {
                reDiag++;
            }
        }

        if (row == 3 || col == 3 || diag == 3 || reDiag == 3) {
            result = true;
        }
        
        return result;
    }
}
