package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1774 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> gods = new ArrayList<>();
        PriorityQueue<God> pq = new PriorityQueue<>();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            gods.add(new int[]{x, y});
        }

        // 각 우주신들간의 거리를 구하기
        for (int i = 0; i < n; i++) {
            int[] god1 = gods.get(i);

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int[] god2 = gods.get(j);
                    double distX = Math.pow(god1[0] - god2[0], 2);
                    double distY = Math.pow(god1[1] - god2[1], 2);

                    pq.offer(new God(i + 1, j + 1, Math.sqrt(distX + distY)));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        while (!pq.isEmpty()) {
            God cur = pq.poll();

            int rootA = find(cur.a);
            int rootB = find(cur.b);

            if (rootA != rootB) {
                union(rootA, rootB);
                answer += cur.distance;
            }
        }

        double result = Math.round(answer * 100) / 100.0;

        System.out.printf("%.2f", result);
    }

    public static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}

class God implements Comparable<God> {
    int a;
    int b;
    double distance;

    public God(int a, int b, double distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    @Override
    public int compareTo(God o) {
        if (this.distance == o.distance) {
            return 0;
        } else {
            if (this.distance > o.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
