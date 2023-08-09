class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();
        int len = tLen - pLen + 1;

        for (int i = 0; i < len; i++) {
            int index = 0;

            while (true) {

                if (index >= pLen) {
                    answer++;
                    break;
                }

                if (t.charAt(i + index) < p.charAt(index)) {
                    answer++;
                    break;
                } else if (t.charAt(i + index) > p.charAt(index)) {
                    break;
                }

                index++;
            }
        }

        return answer;
    }
}