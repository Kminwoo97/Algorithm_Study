import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int lastMissile = -1;
        
        Arrays.sort(targets, (e1, e2) -> {
            if (e1[1] == e2[1]) {
                return e1[0] - e2[0];
            }
            
            return e1[1] - e2[1];
        });
        
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= lastMissile) {
                lastMissile = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}
