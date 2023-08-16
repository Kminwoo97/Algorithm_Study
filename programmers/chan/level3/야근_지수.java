import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
            sum += works[i];
        }

        if (n >= sum) {
            return 0;
        }

        while (n > 0) {
            int cur = pq.poll();
            pq.offer(--cur);
            n--;
        }

        while (!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}