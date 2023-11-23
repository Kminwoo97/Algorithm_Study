import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 400000000200000L;
        
        long start = 0;
        long end = answer;
        long mid = 0;
        
        while (start < end) {
            mid = (start + end) / 2;
            
            if (isEnough(a, b, g, s, w, t, mid)) {
                answer = Math.min(answer, mid);
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean isEnough(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        boolean result = false;
        long totalGold = 0;
        long totalSilver = 0;
        long totalMineral = 0;
        
        for (int i = 0; i < g.length; i++) {
            // time 동안 운반가능 횟수
            long count = time / (t[i] * 2);
            if (time % (t[i] * 2) >= t[i]) {
                count++;
            }
            
            // 해당 도시에서 time시간 동안 옮길 수 있는 금, 은, 자원의 총량
            long gold = Math.min(g[i], w[i] * count);
            long silver = Math.min(s[i], w[i] * count);
            long mineral = Math.min(g[i] + s[i], w[i] * count);
            
            totalGold += gold;
            totalSilver += silver;
            totalMineral += mineral;
        }
        
        if (totalGold >= a && totalSilver >= b && totalMineral >= a + b) {
            result = true;
        }
        
        return result;
    }
}
