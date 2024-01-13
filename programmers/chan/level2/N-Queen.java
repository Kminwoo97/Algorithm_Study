class Solution {
    static int ans = 0;
    
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            find(n, new int[]{0, i}, new boolean[n][n], 1);
        }
        
        return answer = ans;
    }
    
    public void find(int n, int[] start, boolean[][] isVisited, int count) {
        
        if (start[0] == n - 1 && count == n) {
            ans++;
            return;
        }
        
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
        
        for (int i = 0; i < n; i++) {
            if (isVisited[start[0] + 1][i] == false) {
                boolean[][] sub = new boolean[n][n];
                
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (isVisited[j][k] == true) {
                            sub[j][k] = true;
                        }
                    }
                }
                
                find(n, new int[]{start[0] + 1, i}, sub, count + 1);
            }
        }
    }
}
