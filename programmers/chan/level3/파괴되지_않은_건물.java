class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];

        for(int i = 0; i < skill.length; i++) {
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if (skill[i][0] == 1) {
                cal(map, r1, c1, r2, c2, -degree);
            } else {
                cal(map, r1, c1, r2, c2, degree);
            }
        }

        calPrefixSum(map);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += map[i][j];
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }
            
        return answer;
    }
    
    public void cal(int[][] map, int r1, int c1, int r2, int c2, int degree) {                
        map[r1][c1] += degree;
        map[r2 + 1][c1] += -degree;
        map[r1][c2 + 1] += -degree;
        map[r2 + 1][c2 + 1] += degree;
    }
    
    public void calPrefixSum(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                map[i][j] += map[i][j - 1];
            }
        }
        
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 1; j < map.length; j++) {
                map[j][i] += map[j - 1][i];
            }
        }
    }
}
