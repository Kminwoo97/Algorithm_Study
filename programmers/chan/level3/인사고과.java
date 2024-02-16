import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] myScore = scores[0];
        int mySum = myScore[0] + myScore[1];
        
        Arrays.sort(scores, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            
            return e2[0] - e1[0];
        });
        
        int maxEval = 0;
        int rank = 1;
        
        for (int i = 0; i < scores.length; i++) {
            if (maxEval <= scores[i][1]) {
                maxEval = scores[i][1];
                
                if (mySum < scores[i][0] + scores[i][1]) {
                    rank++;
                } 
            } else {
                if (myScore == scores[i]) {
                    rank = -1;
                    break;
                }
            }
        }
        
        return answer = rank;
    }
}
