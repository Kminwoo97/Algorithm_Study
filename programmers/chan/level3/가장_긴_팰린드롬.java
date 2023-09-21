import java.util.*;

class Solution
{
    int max = 1;
    
    public int solution(String s)
    {
        int answer = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            
            sb.append(s.charAt(i));
            sub(s, sb, i);
            
            if (max == s.length()) {
                break;
            }
        }
        
        return answer = max;
    }
    
    public boolean isPalindrome(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;
        
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    public void sub(String s, StringBuilder sb, int index) {
        for (int i = index + 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
            
            if (sb.length() > max && isPalindrome(sb)) {
                max = sb.length();
            }
        }
    }
}
