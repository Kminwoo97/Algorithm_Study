class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                if (ch < 97) {
                    sb.append((char) ((ch + n) % 65 % 26 + 65));
                } else {
                    sb.append((char) ((ch + n) % 97 % 26 + 97));
                }
            } else {
                sb.append(" ");
            }
        }
        
        return answer = sb.toString();
    }
}
