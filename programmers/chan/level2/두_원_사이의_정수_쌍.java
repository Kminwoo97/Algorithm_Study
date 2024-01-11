class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for (int i = -r2; i <= r2; i++) {
            double x1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            double x2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            
            if ((int) x2 == x2) { 
                answer++;
            }
            
            if ((int) x1 == x1) {
                answer++;
            }
            
            answer += ((int) x2 * 2 + 1) - (Math.ceil((int) x1) * 2 + 1);
            System.out.println(i + " " + answer);
        }
        
        return answer;
    }
}
