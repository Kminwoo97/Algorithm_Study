import java.util.*;

class Solution {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (isVisited[i][j] == false && maps[i].charAt(j) != 'X') {
                    list.add(bfs(maps, isVisited, new int[]{i, j, (int) maps[i].charAt(j) - 48}));
                }
            }
        }
        
        if (list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            Collections.sort(list);
            answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
    
    public int bfs(String[] maps, boolean[][] isVisited, int[] start) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            result += cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nextY = cur[0] + moveY[i];
                int nextX = cur[1] + moveX[i];
                
                if (nextY >= 0 && nextY < maps.length &&
                    nextX >= 0 && nextX < maps[0].length() &&
                    maps[nextY].charAt(nextX) != 'X' &&
                    isVisited[nextY][nextX] == false) {
                    
                    isVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, maps[nextY].charAt(nextX) - 48});
                }
            }
        }
        
        return result;
    }
}
