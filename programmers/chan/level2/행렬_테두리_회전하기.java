import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // 2차원 행렬 제작.
        int[][] map = new int[rows + 1][columns + 1];
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = (i - 1) * columns + j;
            }
        }
        
        // 조건에 맞게 rotate
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            answer[i] = rotate(map, x1, y1, x2, y2);
        }
        
        return answer;
    }
    
    public int rotate(int[][] map, int x1, int y1, int x2, int y2) {
        int init = map[x1][y1];
        int min = init;
        
        // (x1, y1)부터 (x2, y2) 까지 시계방향으로 회전
        for (int i = 0; i < x2 - x1; i++) {
            min = Math.min(min, map[x1 + i][y1]);
            map[x1 + i][y1] = map[x1 + i + 1][y1];
        }
        
        for (int i = 0; i < y2 - y1; i++) {
            min = Math.min(min, map[x2][y1 + i]);
            map[x2][y1 + i] = map[x2][y1 + i + 1];
        }
        
        for (int i = 0; i < x2 - x1; i++) {
            min = Math.min(min, map[x2 - i][y2]);
            map[x2 - i][y2] = map[x2 - i - 1][y2];
        }
        
        for (int i = 0; i < y2 - y1; i++) {
            min = Math.min(min, map[x1][y2 - i]);
            map[x1][y2 - i] = map[x1][y2 - i - 1];
        }
        
        map[x1][y1 + 1] = init;
        
        // 회전하는 값 중 가장 작은 값 return
        return min;
    }
}
