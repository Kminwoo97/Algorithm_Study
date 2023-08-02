class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        String lowString = s.toLowerCase();

        for (int i = 0; i < lowString.length(); i++) {
            if (lowString.charAt(i) < 65) {
                sb.append(lowString.charAt(i));
            } else {
                if (i == 0 || lowString.charAt(i - 1) == 32) {
                    sb.append((char) (lowString.charAt(i) - 32));
                } else {
                    sb.append(lowString.charAt(i));
                }
            }
        }

        return answer = sb.toString();
    }
}