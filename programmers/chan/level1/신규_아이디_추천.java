class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        for (int i = 0; i < new_id.length(); i++) {
            if (i + 1 < new_id.length() && new_id.charAt(i) == '.' 
                && new_id.charAt(i + 1) == '.') {
                
                continue;
            }
            
            sb1.append(new_id.charAt(i));
        }
        
        for (int i = 0; i < sb1.length(); i++) {
            if (i == 0 && sb1.charAt(i) == '.') {
                continue;
            }
            
            if (i == sb1.length() - 1 && sb1.charAt(i) == '.') {
                continue;
            }
            
            sb2.append(sb1.charAt(i));
        }
        
        if (sb2.length() == 0) {
            sb2.append("a");
        }
        
        if (sb2.length() >= 16) {
            String sub = sb2.toString().substring(0, 15);
            
            if (sub.charAt(sub.length() - 1) == '.') {
                answer = sub.substring(0, 14);
            } else {
                answer = sub;
            }
            
            return answer;
        }
        
        if (sb2.length() <= 2) {
            char last = sb2.charAt(sb2.length() - 1);
            
            while (sb2.length() < 3) {
                sb2.append(last);
            }
        }
        
        answer = sb2.toString();
        
        return answer;
    }
}
