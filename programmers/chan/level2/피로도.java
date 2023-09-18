import java.util.*;

class Solution {
    static int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        boolean[] isVisited = new boolean[dungeons.length];

        dfs(dungeons, isVisited, k, 0);
        
        return answer = max;
    }
    
    public void dfs(int[][] dungeons, boolean[] isVisited, int k, int index) {
        max = Math.max(max, index);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (isVisited[i] == false && k >= dungeons[i][0]) {
                isVisited[i] = true;
                dfs(dungeons, isVisited, k - dungeons[i][1], index + 1);
                isVisited[i] = false;
            }
        }
    }
}
