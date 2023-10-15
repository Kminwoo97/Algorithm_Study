import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            queue.offer(new int[]{i, sequence[i]});
            
            if (sum > k) {
                while (sum > k) {
                    int[] p = queue.poll();
                    sum -= p[1];
                }
            }
            
            if (sum == k) {
                if ((answer[1] - answer[0]) > (i - queue.peek()[0])) {
                    answer[0] = queue.peek()[0];
                    answer[1] = i;
                }
            }
        }
        
        return answer;
    }
}
