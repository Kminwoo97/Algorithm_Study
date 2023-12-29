class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        
        // 몇대 몇 비율인지 확인
        int gcd = getGCD(w, h);
        int row = w / gcd;
        int col = h / gcd;
        
        // 정사각형인 경우
        if (row == col) {
            answer -= w; 
        } else {
            // 아닌경우
            long sum = row * col;
            
            sum -= (long) ((row - 1) * (col - 1));
            answer -= sum * gcd;
        }
        
        return answer;
    }
    
    public int getGCD(int w, int h) {
        if (w == 0) {
            return h;
        }
        
        if (w >= h) {
            return getGCD(w % h, h);
        } else {
            return getGCD(h % w, w);
        }
    }
}
