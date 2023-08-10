public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = brown + yellow;
        int i = 1;

        while (true) {
            if (width % i == 0) {
                int quot = width / i;

                if (quot < i) {
                    break;
                }

                if (brown == ((quot - 1) + (i - 1)) * 2) {
                    answer[0] = quot;
                    answer[1] = i;
                    break;
                }
            }

            i++;
        }

        return answer;
    }
}
