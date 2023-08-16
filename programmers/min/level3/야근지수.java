import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0L;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works)
            pq.offer(work);
        
        while(pq.peek() > 0 && n > 0){
            int x = pq.poll() - 1;
            n--;
            pq.offer(x);
        }
        
        while(!pq.isEmpty()){
            int x = pq.poll();
            answer += x*x;
        }
        
        return answer;
    }
}
