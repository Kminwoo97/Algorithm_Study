import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int len = 0;
        
        for (int i = 0; i < edges.length; i++) {
            len = Math.max(len, Math.max(edges[i][0], edges[i][1]));
        }
        
        List<Integer>[] adj = new List[len + 1];
        int[] inputEdges = new int[len + 1];
        
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            
            adj[start].add(end);
            inputEdges[end]++;
        }
                
        // 1. 생성한 정점 찾기 - 들어오는 간선 없는 노드
        for (int i = 1; i < len; i++) {
            if (inputEdges[i] == 0 && adj[i].size() >= 2) {
                answer[0] = i;
            }
        }
        
        // 2. 생성한 정점과 연결된 노드들을 시작점으로 그래프 모양 찾기
        for (int i = 0; i < adj[answer[0]].size(); i++) {
            // 도넛 모양 그래프 찾기 - 방문하지 않은 간선을 따라 마지막에 나한테 돌아오는 경우
            // 막대 모양 그래프 찾기 - 순환하지 않는 경우
            // 8자 모양 그래프 찾기 - 나가는 간선이 두 개 이상인 경우
            String result = find(adj, adj[answer[0]].get(i));
            
            if (result.equals("donut")) {
                answer[1]++;
            } else if (result.equals("stick")) {
                answer[2]++;
            } else if (result.equals("figure8")) {
                answer[3]++;
            } 
        }

        return answer;
    }
    
    public String find(List<Integer>[] adj, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[adj.length];
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            isVisited[cur] = true;
            
            if (adj[cur].size() > 1) {
                return "figure8";
            }
            
            if (adj[cur].size() == 0) {
                return "stick";
            }
            
            for (int j = 0; j < adj[cur].size(); j++) {
                int next = adj[cur].get(j);
                
                if (isVisited[next] == false) {
                    queue.add(next);
                }
            }
        }
        
        return "donut";
    }
}
