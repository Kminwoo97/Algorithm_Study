import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right - (int)left + 1];
    
        int i=0;
        for(long j=left; j<=right; j++){
            int x = (int)Math.max(j / n, j % n) + 1;
            answer[i] = x;
            i++;
        }
        
        return answer;
    }
}
