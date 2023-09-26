import java.util.*;

class Solution {
    static int[] node;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        node = new int[n + 1];
        List<Integer>[] adj = new ArrayList[n + 1];
        boolean[] isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);
        }
        
        isVisited[1] = true;
        dfs(adj, isVisited, 1);
        
        for (int i = 1; i < node.length; i++) {
            int diff = n - node[i];
            answer = Math.min(answer, Math.abs(node[i] - diff));
        }
        
        return answer;
    }
                                          
    public int dfs(List<Integer>[] adj, boolean[] isVisited, int cur) {
        int count = 1; // 나 포함 전력망 내 송전탑 갯수
        
        for (int next : adj[cur]) {
            if (isVisited[next] == false) {
                isVisited[next] = true;
                count += dfs(adj, isVisited, next);
            }
        }
        
        return node[cur] = count;
    }
}
