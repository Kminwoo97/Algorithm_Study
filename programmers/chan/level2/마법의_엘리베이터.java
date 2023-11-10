import java.util.*;

class Solution {
    
    public int solution(int storey) {
        int answer = 0;
        
        return answer = bfs(storey);
    }
    
    public int bfs(int storey) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{storey, 0});
        int min = 10000000;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == 0) {
                min = Math.min(min, cur[1]);
                continue;
            }
            
            int num = cur[0] % 10;
            
            if (num > 5) {
                queue.add(new int[]{cur[0] / 10 + 1, cur[1] + 10 - num});
            } else if (num == 5) {
                queue.add(new int[]{cur[0] / 10, cur[1] + num});
                queue.add(new int[]{cur[0] / 10 + 1, cur[1] + 10 - num});
            } else {
                queue.add(new int[]{cur[0] / 10, cur[1] + num});
            }
        }
        
        return min;
    }
}
