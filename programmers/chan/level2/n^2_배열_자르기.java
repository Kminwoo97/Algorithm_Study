import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        List<Integer> list = new ArrayList<>();
    
        for (Long i = left; i <= right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
            
            list.add(Math.max((row + 1), (col + 1)));
        }
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}