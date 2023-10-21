import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(0, 4);
        
        while (n > 0) {
            int remain = n % 3;
            sb.append(map.get(remain));
            
            n /= 3;
            
            if (remain % 3 == 0) {
                n--;
            }
        }
        
        return answer = sb.reverse().toString();
    }
}
