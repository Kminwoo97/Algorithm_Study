class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        for (int start = 0; start <= 1; start++) {
            int[] sum = new int[n];        
            
            for (int i = start; i < n; i++) {
                sum[i] = Math.max(money[i] + sum[(i - 2 + n) % n], sum[(i - 1 + n) % n]);
            }
            
            if (start == 0) {
                answer = sum[n - 2];
            } else {
                answer = Math.max(answer, sum[n - 1]);
            }
        }
        
        return answer;
    }
}
