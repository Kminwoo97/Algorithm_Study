class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long total= (long)Math.pow(d,2);
        for(int a=0; k*a<=d; a++){
            double tmp = (total - (long)Math.pow(k*a,2)) / (long)Math.pow(k,2);
            answer += (long)Math.sqrt(tmp) + 1;
        }
        return answer;
    }
}
