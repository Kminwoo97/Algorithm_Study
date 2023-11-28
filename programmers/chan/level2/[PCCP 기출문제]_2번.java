import java.util.*;

class Solution {
    static int[] moveX = {-1, 1, 0, 0};// 상하좌우 
    static int[] moveY = {0, 0, -1, 1};
    static Map<Integer, Integer> map = new HashMap<>(); // 석유덩어리 번호, 크기
    static int[][] memo; // x y좌표, 석유덩어리 번호
    static int num = 0;
    
    public int solution(int[][] land) {
        int answer = 0;
        memo = new int[land.length][land[0].length];
        boolean[][] isVisited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && isVisited[i][j] == false) {
                    bfs(land, isVisited, i, j);
                }
            }
        }
        
        for (int i = 0; i < land[0].length; i++) {
            int max = 0;
            
            boolean[] isVisitedOil = new boolean[num];
            
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1 && isVisitedOil[memo[j][i]] == false) {
                    isVisitedOil[memo[j][i]] = true;
                    max += map.get(memo[j][i]);
                }
            }
            
            answer = Math.max(answer, max);
        }
        
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] isVisited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        
        queue.add(new int[]{x, y});
        isVisited[x][y] = true;

        int result = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            result++;
            list.add(cur);

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                
                if (nextX >= 0 && nextX < land.length &&
                    nextY >= 0 && nextY < land[0].length &&
                    land[nextX][nextY] == 1 && 
                    isVisited[nextX][nextY] == false) {
                    
                    isVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        
        for (int[] el : list) {
            memo[el[0]][el[1]] = num;
            map.put(num, result);
        }
        
        num++;
    }
}
