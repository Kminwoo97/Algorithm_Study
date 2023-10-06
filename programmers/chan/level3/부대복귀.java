import java.util.*;

class Solution {
    static int[] distance;
        
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        distance = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        int max = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        Arrays.fill(distance, max);
        dijkstra(graph, destination);
        
        for (int i = 0; i < sources.length; i++) {
            if (distance[sources[i]] == max) {
                answer[i] = -1;
                continue;
            }
            
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
    
    public void dijkstra(List<Integer>[] graph, int destination) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(destination);
        distance[destination] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                
                if (distance[next] > distance[cur] + 1) {
                    distance[next] = distance[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
