class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char alpha = (char) (s.charAt(i) + n);

            if (s.charAt(i) != ' ') {
                if (s.charAt(i) <= 90) {
                    if (alpha > 90) {
                        alpha -= 26;
                    }
                } else {
                    if (alpha > 122) {
                        alpha -= 26;
                    }
                }

                sb.append(alpha);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return answer = sb.toString();
    }
}