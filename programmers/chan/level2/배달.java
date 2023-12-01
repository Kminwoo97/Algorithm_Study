import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Node>[] adj = new ArrayList[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1]; 
            int weight = road[i][2];
            adj[start].add(new Node(end, weight));
            adj[end].add(new Node(start, weight));
        }
        
        // 현재 마을에서 다른 마을까지 가는데 걸리는 최단시간을 갱신하며 저장
        dijkstra(adj, dp, road, 1);
        
        // k시간 이하인 값 찾아서 count
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    public void dijkstra(List<Node>[] adj, int[] dp, int[][] road, int num) {
        PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for (int i = 0; i < adj[cur.num].size(); i++) {
                Node next = adj[cur.num].get(i);
                
                if (dp[next.num] > cur.weight + next.weight) {
                    dp[next.num] = cur.weight + next.weight;
                    pq.add(new Node(next.num, cur.weight + next.weight));
                }
            }
        }
    }
}

class Node {
    int num;
    int weight;
    
    public Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}
