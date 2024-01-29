import java.util.*;

class Solution {
    static int[] moveX = {0, 0, -1, 1}; // 상하좌우
    static int[] moveY = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        
        for (int i = 0; i < rectangle.length; i++) {
            int startX = rectangle[i][0];
            int startY = rectangle[i][1];
            int endX = rectangle[i][2];
            int endY = rectangle[i][3];
            
            // 테두리에만 1 처리
            for (int j = startX * 2; j <= endX * 2; j++) {
                if (map[j][startY * 2] != 2) {
                    map[j][startY * 2] = 1;
                }
                
                if (map[j][endY * 2] != 2) {
                    map[j][endY * 2] = 1;
                }
            }
            
            for (int j = startY * 2; j <= endY * 2; j++) {
                if (map[startX * 2][j] != 2) {
                    map[startX * 2][j] = 1;
                }
                
                if (map[endX * 2][j] != 2) {
                    map[endX * 2][j] = 1;
                }
            }
            
            // 내부는 2 처리
            for (int j = startX * 2 + 1; j < endX * 2; j++) {
                for (int k = startY * 2 + 1; k < endY * 2; k++) {
                    map[j][k] = 2;
                }
            }
        }
        
        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, map);
        
        return answer / 2;
    }
    
    public int bfs(int startX, int startY, int endX, int endY, int[][] map) {
        int result = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        queue.add(new int[]{startX, startY, 0});
        isVisited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
                        
            if (cur[0] == endX && cur[1] == endY) {
                result = Math.min(result, cur[2]);
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                
                if (nextX >= 0 && nextX < map.length &&
                   nextY >= 0 && nextY < map[0].length &&
                   map[nextX][nextY] == 1 &&
                   isVisited[nextX][nextY] == false) {
                    isVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, cur[2] + 1});
                }
            }
        }
        
        return result;
    }
}
