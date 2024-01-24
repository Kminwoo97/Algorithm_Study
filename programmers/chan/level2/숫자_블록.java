import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        int idx = 0;
        
        for (int i = (int) begin; i <= end; i++) {
            answer[idx++] = getGD(i);    
        }        
        
        if (begin == 1) {
            answer[0] = 0;
        }
                
        return answer;
    }
    
    // 자기 자신을 제외한 가장 큰 약수 반환
    public int getGD(int n) {
        int result = 1;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int quot = n / i;
                
                // 천만까지의 숫자가 적힌 블럭까지만 사용
                if (quot > 10000000) {
                    result = i;
                } else {
                    result = quot;
                    break;
                }
            }
        }
        
        return result;
    }
}
