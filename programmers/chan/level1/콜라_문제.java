class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int entire = n;

        while (n > 0) {
            int remain = entire % a;
            n = entire / a;
            answer += n * b;

            entire = remain + n * b;
        }

        return answer;
    }
}