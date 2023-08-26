import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer>[] list = new ArrayList[n];
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 직접 연결 체크
                if (i != j && computers[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                stack.push(i);
                dfs(list, stack, isVisited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(List<Integer>[] list, Stack<Integer> stack, boolean[] isVisited) {
        int p = stack.pop();
        
        for (int i = 0; i < list[p].size(); i++) {
            int next = list[p].get(i);
            if (isVisited[next] == false) {
                isVisited[next] = true;
                stack.push(next);
                
                dfs(list, stack, isVisited);
            }
        }
    }
}
