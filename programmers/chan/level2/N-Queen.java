class Solution {
    static int ans = 0;
    
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                find(n, new int[]{i, j}, new boolean[n][n], 1);
            }
        }
        
        return answer = ans;
    }
    
    public void find(int n, int[] start, boolean[][] isVisited, int count) {
        
        for (int i = 0; i < n; i++) {
            if (start[1] + i < n) {
                isVisited[start[0]][start[1] + i] = true;
            }
            
            if (start[0] + i < n) {
                isVisited[start[0] + i][start[1]] = true;
            }
            
            if (start[0] + i < n && start[1] + i < n) {
                isVisited[start[0] + i][start[1] + i] = true;
            }
            
            if (start[0] + i < n && start[1] - i >= 0) {
                isVisited[start[0] + i][start[1] - i] = true;
            }
        }
        
        if (n == count) {
            ans++;
            return;
        }
        
        for (int i = start[0]; i < n; i++) {
            for (int j = start[1]; j < n; j++) {
                if (isVisited[i][j] == false) {
                    isVisited[i][j] = true;
                    System.out.println(i + " " + j + " " + count + 1);
                    find(n, new int[]{i, j}, isVisited, count + 1);
                }
            }
        }
    }
}
