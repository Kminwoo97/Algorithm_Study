import java.util.*;

class Solution {
    static int[] moveY = {-1, 1, 0, 0}; // 상하좌우
    static int[] moveX = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (isVisited[i][j] == false && maps[i].charAt(j) != 'X') {
                    list.add(bfs(maps, isVisited, i, j));
                }
            }
        }
        
        if (list.size() == 0) {
            answer = new int[]{-1};
        } else {
            Collections.sort(list);
            answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
    
    public int bfs(String[] maps, boolean[][] isVisited, int y, int x) {
        isVisited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        int sum = 0;
        
        queue.offer(new int[]{y, x});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            sum += (int) (maps[cur[0]].charAt(cur[1]) - 48);
            
            for (int i = 0; i < 4; i++) {
                int nextY = cur[0] + moveY[i];
                int nextX = cur[1] + moveX[i];
                
                if (nextY >= 0 && nextY < maps.length && nextX >= 0 && nextX < maps[0].length() &&
                    isVisited[nextY][nextX] == false && maps[nextY].charAt(nextX) != 'X') {
                    isVisited[nextY][nextX] = true;
                    
                    queue.offer(new int[]{nextY, nextX});
                }
            }
        }
        
        return sum;
    }
}
