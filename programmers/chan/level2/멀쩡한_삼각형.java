class Solution {
    public long solution(int w, int h) {
        long answer = w * h;
        
        int gcd = getGCD(w, h);
        int row = w / gcd;
        int col = h / gcd;
        
        // 정사각형인 경우
        if (row == col) {
            answer -= row;  
        } else {
            // 아닌경우
            long sum = 0;
            int remain = 0;
                
            if (row > col) {
                remain = (row - 1) / col + 1;
            } else {
                remain = (col - 1) / row + 1;
            }
            
            if (row == 1 || col == 1) {
                sum += remain;
            } else {
                sum += remain * 2;
                sum += (col - (remain - 1) * 2) * (row - 2);
            }
            
            answer -= sum * (w / row);
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
