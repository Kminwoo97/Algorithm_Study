import java.util.*;

class Solution {
    static long ans = 0;
    
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i <= d; i++) {
            find(i, k, d);
        }
        
        return answer = ans;
    }
                
    public void find(int a, int k, int d) {
        double kExp = Math.pow(k, 2);
        double b = Math.sqrt(Math.pow(d, 2) / kExp - Math.pow(a, 2));
        if (b >= 0.0) {
            ans += ((int) b + 1);
        }
            
    }
}
