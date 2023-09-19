import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        int xCount = 1;
        int notXCount = 0;
        char x = s.charAt(index);
        
        while(index < s.length()) {            
            if (index + 1 < s.length()) {
                if (s.charAt(index + 1) != x) {
                    notXCount++;
                } else {
                    xCount++;
                }
            } else {
                answer++;
                break;
            }
            
            index++;
            
            if (xCount == notXCount) {
                answer++;

                if (index + 1 < s.length()) {
                    s = s.substring(index + 1);
                } else {
                    break;
                }
                
                xCount = 1;
                notXCount = 0;
                index = 0;
                x = s.charAt(index);
            }
        }
        
        return answer;
    }
}
