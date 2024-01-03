import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[] pick = new int[3];
        
        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                pick[0] += 1;
                pick[1] += 5;
                pick[2] += 25;
            } else if (minerals[i].equals("iron")) {
                pick[0] += 1;
                pick[1] += 1;
                pick[2] += 5;
            } else {
                pick[0] += 1;
                pick[1] += 1;
                pick[2] += 1;
            }
            
            if (i % 5 == 4) {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                
                for (int j = 0; j < 3; j++) {
                    if (picks[j] != 0 && min > pick[j]) {
                        min = pick[j];
                        minIndex = j;
                    }
                }
                
                answer += min;
                picks[minIndex]--;
                pick[0] = 0;
                pick[1] = 0;
                pick[2] = 0;
            }
        }
        
        if (picks[0] != 0 || picks[1] != 0 || picks[2] != 0) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < 3; j++) {
                if (picks[j] != 0 && min > pick[j]) {
                    min = pick[j];
                    minIndex = j;
                }
            }

            answer += min;
        }
        
        return answer;
    }
}
