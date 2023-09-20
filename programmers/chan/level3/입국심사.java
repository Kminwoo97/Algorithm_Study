import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long max = (long) times[0] * n;
        long min = 1;
                
        while (min <= max) {
            long time = (max + min) / 2;
            int completed = 0;
            
            for (int i = 0; i < times.length; i++) {
                completed += time / times[i];
                
                if (completed >= n) {
                    break;
                }
            }
            
            if (completed >= n) {
                answer = Math.min(answer, time);
                max = time - 1;
            } else {
                min = time + 1;
            }
        }
        
        return answer;
    }
}
