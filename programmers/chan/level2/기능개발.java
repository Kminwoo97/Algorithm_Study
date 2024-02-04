import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remainTime = (99 - progresses[i]) / speeds[i] + 1;
            
            queue.add(remainTime);
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int cnt = 1;
            
            while (!queue.isEmpty() && cur >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            
            ans.add(cnt);
        }
        
        answer = new int[ans.size()];
        
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
