package org.example.boj;

import java.io.*;
import java.util.*;

public class p1197 {
    static List<Node>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        adj = new List[v + 1];

        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        long sum = bfs(v);

        System.out.println(sum);
    }

    public static long bfs(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        boolean[] isVisited = new boolean[v + 1];
        long sum = 0;

        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (isVisited[cur.num] == true) {
                continue;
            }

            sum += cur.weight;
            isVisited[cur.num] = true;

            for (int i = 0; i < adj[cur.num].size(); i++) {
                Node next = adj[cur.num].get(i);

                if (isVisited[next.num] == false) {
                    pq.offer(new Node(next.num, next.weight));
                }
            }
        }

        return sum;
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
