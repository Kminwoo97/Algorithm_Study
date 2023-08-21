import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer>[] pq = new PriorityQueue[2];
        
        pq[0] = new PriorityQueue<>();
        pq[1] = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            
            if (str[0].equals("I")) {
                int number = Integer.parseInt(str[1]);
                pq[0].offer(number);
                pq[1].offer(number);
            } else {
                if (!pq[0].isEmpty()) {
                    int p = 0;
                    
                    if (str[1].equals("1")) {
                        p = pq[1].poll();
                    } else {
                        p = pq[0].poll();
                    }

                    pq[0].remove(p);
                    pq[1].remove(p);
                }
            }
        }
        
        if (!pq[0].isEmpty()) {
            int p = pq[1].poll();
            
            pq[0].remove(p);
            
            answer[0] = p;
            answer[1] = pq[0].poll();
        }
        
        return answer;
    }
}
