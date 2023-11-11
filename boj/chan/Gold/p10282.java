package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p10282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Node>[] adj = new List[n + 1];
            int[] dist = new int[n + 1]; // c로 부터 index 까지 도달 가능한 가장 짧은 시간.

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;

            for (int j = 1; j < adj.length; j++) {
                adj[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                adj[b].add(new Node(a, s));
            }

            dijkstra(adj, dist, c);

            int count = 0;
            int max = 0;

            for (int j = 0; j < dist.length; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    count++;
                    max = Math.max(max, dist[j]);
                }
            }

            System.out.println(count + " " + max);
        }
    }

    public static void dijkstra(List<Node>[] adj, int[] dist, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < adj[cur.no].size(); i++) {
                Node dependentNode = adj[cur.no].get(i);
                int nextWeight = cur.weight + dependentNode.weight;

                if (dist[dependentNode.no] > nextWeight) {
                    dist[dependentNode.no] = nextWeight;
                    pq.add(new Node(dependentNode.no, nextWeight));
                }
            }
        }
    }
}

class Node {
    int no;
    int weight;

    public Node(int no, int weight) {
        this.no = no;
        this.weight = weight;
    }
}
