import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
        int remain = n;
        
        for (int i = 0; i < enemy.length; i++) {
            remain -= enemy[i];
            pq.add(enemy[i]);
            
            if (remain < 0) {
                if (!pq.isEmpty() && k > 0) {
                    remain += pq.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}
