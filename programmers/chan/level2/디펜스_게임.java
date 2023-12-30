import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        Arrays.sort(enemy);
        
        for (int i = enemy.length - 1; i > k; i--) {
            n -= enemy[i];
            
            if (n < 0) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
