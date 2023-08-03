public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 1;
        int i = 1;

        while (i < n) {
            int sum = 0;
            int j = i;

            while (sum < n) {
                sum += j;
                j++;

                if (sum == n) {
                    answer++;
                    break;
                }
            }

            i++;
        }

        return answer;
    }
}
