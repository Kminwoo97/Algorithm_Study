import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }
        
        while (!queue.isEmpty()) {
            Process cur = queue.poll();
            boolean isFirst = true;
            
            for (Process next : queue) {
                if (cur.priority < next.priority) {
                    queue.offer(cur);
                    
                    while (next.num != queue.peek().num) {
                        queue.offer(queue.poll());
                    }
                    
                    isFirst = false;
                    break;
                } 
            }
            
            if (isFirst == true) {
                answer++;

                if (cur.num == location) {
                    break;
                }
            }
        }
        
        return answer;
    }
}

class Process {
    int num;
    int priority;
    
    Process (int num, int priority) {
        this.num = num;
        this.priority = priority;
    }
}
