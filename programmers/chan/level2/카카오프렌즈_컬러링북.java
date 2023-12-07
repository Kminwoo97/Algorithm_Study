import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] moveX = {0, 0, -1, 1}; // 상하좌우
        int[] moveY = {1, -1, 0, 0};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        boolean[][] isVisited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && isVisited[i][j] == false) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, 
                                                bfs(picture, isVisited, i, j, picture[i][j], moveY, moveX));
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public int bfs(int[][] picture, boolean[][] isVisited, int i, int j, int color, int[] moveY, int[] moveX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        isVisited[i][j] = true;
        int areaCount = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            areaCount++;
            
            for (int k = 0; k < 4; k++) {
                int nextY = cur[0] + moveY[k];
                int nextX = cur[1] + moveX[k];
                
                if (nextY >= 0 && nextY < picture.length &&
                   nextX >= 0 && nextX < picture[0].length &&
                   picture[nextY][nextX] == color &&
                   isVisited[nextY][nextX] == false) {
                    
                    isVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
        
        return areaCount;
    }
}
