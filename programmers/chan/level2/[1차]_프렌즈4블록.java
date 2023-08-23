import java.util.*;

class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    static int[] moveX = {-1, 0, -1}; // 위 왼쪽 왼쪽위대각선
    static int[] moveY = {0, -1, -1}; // 위 왼쪽 왼쪽위대각선
        
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean hasDeletedBlocks = true;
        boolean[][] isDeleted = new boolean[m][n];
        char[][] blocks = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
        
        while (hasDeletedBlocks) {
            hasDeletedBlocks = false;
            
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    Queue<int[]> indices = new LinkedList<>();
                    indices.offer(new int[]{i, j});

                    for (int k = 0; k < 3; k++) {
                        int nextX = i + moveX[k];
                        int nextY = j + moveY[k];

                        if (nextX >= 0 && nextX < m && 
                            nextY >= 0 && nextY < n && 
                            blocks[nextX][nextY] != '0' &&
                            blocks[nextX][nextY] == blocks[i][j]) {
                            
                            indices.offer(new int[]{nextX, nextY});
                        }
                    }

                    if (indices.size() == 4) {
                        while (!indices.isEmpty()) {
                            int[] poll = indices.poll();
                            isDeleted[poll[0]][poll[1]] = true;
                        }
                    }
                }
            }
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isDeleted[i][j] == true) {
                        isDeleted[i][j] = false;
                        blocks[i][j] = '0';
                        hasDeletedBlocks = true;
                        answer++;
                    }
                }
            }
            
            int p = 0;
            // 윗 블럭들을 아래로 이동
            boolean isMoved = true;
            
            while(isMoved) {
                p++;
                isMoved = false;
                char temp = ' ';

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i - 1 >= 0 && blocks[i][j] == '0' && 
                            blocks[i - 1][j] != '0') {
                            blocks[i][j] = blocks[i - 1][j];
                            blocks[i - 1][j] = '0';
                            isMoved = true;
                        }
                    }
                }
            }
        }
        
        return answer;
    }        
}
