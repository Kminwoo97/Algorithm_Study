import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] isVisited = new boolean[cards.length];
        List<Integer> groups = new ArrayList<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                groups.add(bfs(cards, isVisited, cards[i]));
            }
        }
        
        if (groups.size() < 2) {
            answer = 0;
        } else {
            Collections.sort(groups, Collections.reverseOrder());
            answer = groups.get(0) * groups.get(1);
        }
        
        return answer;
    }
    
    public int bfs(int[] cards, boolean[] isVisited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int result = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result++;
            
            if (isVisited[cur - 1] == false) {
                isVisited[cur - 1] = true;
                queue.add(cards[cur - 1]);
            }
        }
        
        return result;
    }
}
