import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = score.length - 1; i >= 0; i--) {
            queue.offer(score[i]);
            
            if (queue.size() == m) {
                int min = 10;
                
                while (!queue.isEmpty()) {
                    int p = queue.poll();
                    
                    if (p < min) {
                        min = p;    
                    }
                }
                
                answer += min * m;
            }
        }
        
        return answer;
    }
}
