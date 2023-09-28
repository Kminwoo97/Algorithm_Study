class Solution {
    static int value = 0;
    static boolean[][] isVisited;
    
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] tower = new int[n][n];
        isVisited = new boolean[n][n];
        
        dfs(tower, n, new int[]{0, 0});
        
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tower[i][j] != 0) {
                    answer[index++] = tower[i][j];
                }
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] tower, int n, int[] start) {
        if (start[0] < 0 || start[0] >= tower.length ||
            start[1] < 0 || start[1] >= tower.length ||
            isVisited[start[0]][start[1]] == true) {
            return;
        }
        
        // 1. 아래로
        for (int i = 0; i < n; i++) {
            if (isVisited[start[0] + i][start[1]] == false) {
                tower[start[0] + i][start[1]] = ++value;
                isVisited[start[0] + i][start[1]] = true;
            }
        }
        
        // 2. 옆으로
        for (int i = 1; i < n; i++) {
            if (isVisited[start[0] + n - 1][start[1] + i] == false) {
                tower[start[0] + n - 1][start[1] + i] = ++value;
                isVisited[start[0] + n - 1][start[1] + i] = true;
            }
        }
        
        // 3. 대각선으로
        for (int i = 1; i < n - 1; i++) {
            if (isVisited[start[0] + n - 1 - i][start[1] + n - 1 - i] == false) {
                tower[start[0] + n - 1 - i][start[1] + n - 1 - i] = ++value;
                isVisited[start[0] + n - 1 - i][start[1] + n - 1 - i] = true;
            }
        }
        
        dfs(tower, n - 3, new int[]{start[0] + 2, start[1] + 1});
    }
}
