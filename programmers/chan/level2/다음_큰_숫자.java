public class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        int oneCount = Integer.bitCount(n);

        while (true) {
            int subOneCount = Integer.bitCount(++n);

            if (subOneCount == oneCount) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}
