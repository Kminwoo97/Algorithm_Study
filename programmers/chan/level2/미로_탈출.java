import java.util.*;

class Solution {
    static int[] lever = new int[2];
    
    public int solution(String[] maps) {
        int answer = -1;
        int lDist = 0;
        int eDist = 0;
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    lDist = bfs(maps, new int[]{i, j}, 'L');
                    break;
                }
            }
        }
        
        if (lDist != -1) {
            eDist = bfs(maps, lever, 'E');
            
            if (eDist == -1) {
                answer = -1;
            } else {
                answer = lDist + eDist;
            }
        }
        
        return answer;
    }
    
    public int bfs(String[] maps, int[] start, char destination) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        int[] moveX = {0, 0, -1, 1};
        int[] moveY = {-1, 1, 0, 0};
        int result = -1;
        isVisited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (maps[cur[0]].charAt(cur[1]) == destination) {
                result = cur[2];
                
                if (destination == 'L') {
                    lever[0] = cur[0];
                    lever[1] = cur[1];
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int nextY = cur[0] + moveY[i];
                int nextX = cur[1] + moveX[i];
                
                if (nextY >= 0 && nextY < maps.length && 
                    nextX >= 0 && nextX < maps[0].length() &&
                    maps[nextY].charAt(nextX) != 'X' &&
                    isVisited[nextY][nextX] == false) {
                    
                    isVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, cur[2] + 1});
                }
            }
        }
        
        return result;
    }
}
