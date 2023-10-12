import java.util.*;

class Solution {
    static long cur1 = 0;
    static long cur2 = 0;
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            cur1 += queue1[i];
            q1.offer(queue1[i]);
        }
        
        for (int i = 0; i < queue2.length; i++) {
            cur2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        if ((cur1 + cur2) % 2 != 0) {
            return answer;
        }
        
        int end = queue1.length * 4;
        int count = find(q1, q2, end);
        
        return answer = count;
    }
    
    public int find(Queue<Integer> q1, Queue<Integer> q2, int end) {
        int count = 0;
        
        while (cur1 != cur2) {
            if (cur1 == cur2) {
                break;
            }
            
            if (count > end) {
                count = -1;
                break;
            }
            
            if (cur1 < cur2) {
                int p = q2.poll();

                q1.offer(p);
                cur1 += p;
                cur2 -= p;
            } else {
                int p = q1.poll();

                q2.offer(p);
                cur1 -= p;
                cur2 += p;
            }
            
            count++;
        }
        
        return count;
    }
}
