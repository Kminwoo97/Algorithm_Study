import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<Node>[] adj = new ArrayList[n + 1];
    
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
    
        for (int i = 0; i < fares.length; i++) {
            adj[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            adj[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }
        
        int[] S = dijkstra(adj, s);
        int[] A = dijkstra(adj, a);
        int[] B = dijkstra(adj, b);
        
        // s -> x(합승구간) 거쳐서 x -> a, x -> b 가는 최소비용
        for (int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, S[i] + A[i] + B[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(List<Node>[] adj, int start) {
        Queue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[adj.length];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[start] = 0;
        queue.offer(new Node(start, 0));
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            for (Node next : adj[cur.num]) {
                if (dist[next.num] > cur.cost + next.cost) {
                    dist[next.num] = cur.cost + next.cost;
                    queue.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
        
        return dist;
    }
}

class Node implements Comparable<Node> {
    int num;
    int cost;
    
    Node (int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
