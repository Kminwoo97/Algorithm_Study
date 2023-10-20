package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1922 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        PriorityQueue<Computer> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Computer(a, b, c));
        }

        int answer = 0;

        while(!pq.isEmpty()) {
            Computer cur = pq.poll();
            int rootA = find(cur.a);
            int rootB = find(cur.b);

            if (rootA != rootB) {
                union(rootA, rootB);
                answer += cur.weight;
            }
        }

        System.out.println(answer);
    }

    public static int find(int n) {
        if (parent[n] == n) return n;

        return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b) {
        parent[b] = a;
    }
}

class Computer {
    int a;
    int b;
    int weight;

    public Computer(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }
}
