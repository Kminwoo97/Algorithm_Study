public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2]; // 이진변환 횟수, 제거된 모든 0의 갯수

        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            StringBuilder lenSb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    sb.append("1");
                }
            }

            int len = sb.length();

            while (len > 0) {
                lenSb.append(len % 2);
                len /= 2;
            }

            lenSb.reverse();
            answer[0]++;
            s = lenSb.toString();
        }

        return answer;
    }
}
