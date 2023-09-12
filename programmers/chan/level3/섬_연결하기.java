import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i< costs.length; i++) {
            // 부모가 같은지 확인
            if (find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                answer += costs[i][2];
                
                // 합치기
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
    
    // 부모노드 찾기
    public int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        
        return find(parent, parent[node]);
    }
    
    // 노드 연결
    public void union(int[] parent, int node1, int node2) {
        int p1 = find(parent, node1);
        int p2 = find(parent, node2);
        
        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }
}
