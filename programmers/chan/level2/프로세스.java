import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }
        
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int[] pre = q.poll();
            boolean isFirst = true;
            
            for (int[] cur : q) {
                if (pre[1] < cur[1]) {
                    q.add(pre);
                    isFirst = false;
                    break;
                }
            }
            
            if (isFirst) {
                cnt++;
                
                if (pre[0] == location) {
                    answer = cnt;
                    break;
                }                
            }
        }
        
        return answer;
    }
}
