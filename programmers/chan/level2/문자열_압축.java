import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i < s.length(); i++) {
            answer = Math.min(answer, getCompressedLength(s, i));
        }
            
        return answer;
    }
    
    public int getCompressedLength(String s, int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int last = 0;
        
        for (int i = 0; i + n <= s.length(); i += n) {
            list.add(s.substring(i, i + n));
            last = i;
        }

        if (last + n < s.length()) {
            list.add(s.substring(last + n));
        }
        
        String pre = "";
        int count = 1;
        
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            
            if (str.equals(pre)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                
                sb.append(pre);
                count = 1;
            }
            
            if (i == list.size() - 1) {
                if (count > 1) {
                    sb.append(count).append(pre);
                } else {
                    sb.append(str);
                }
            }
            pre = str;
        }
        
        return sb.length();
    }
}
