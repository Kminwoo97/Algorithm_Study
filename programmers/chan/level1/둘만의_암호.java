import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Map<Character, Boolean> map = new HashMap<>();
        
        for (int i = 0; i < skip.length(); i++) {
            map.put(skip.charAt(i), true);
        }
        
        for (int i = 0; i < s.length(); i++) {
            int origin = s.charAt(i);
            int encoded = origin;
            
            int idx = 0;
            int end = index;
            while (idx < end) {
                encoded++;
                
                if (encoded > 122) {
                    encoded -= 26;
                }
                
                if (map.getOrDefault((char) encoded, false) == true) {
                    end++;
                }
                
                idx++;
            }
            
            answer += (char) encoded;
        }
        
        return answer;
    }
}
