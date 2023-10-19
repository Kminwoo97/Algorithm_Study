package org.example.boj;

import java.util.*;
import java.io.*;

public class p13549 {
    static int[] move = new int[]{-1, 1, 2};
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dist = new int[100001];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        bfs(n);

        System.out.println(dist[k]);
    }

    public static void bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = cur[0];

                if (i == 2) {
                    next *= move[i];

                    if (next >= 0 && next < dist.length && dist[next] > cur[1]) {
                        dist[next] = cur[1];
                        queue.add(new int[]{next, cur[1]});
                    }
                } else {
                    next += move[i];

                    if (next >= 0 && next < dist.length && dist[next] > cur[1] + 1) {
                        dist[next] = cur[1] + 1;
                        queue.add(new int[]{next, cur[1] + 1});
                    }
                }
            }
        }
    }
}
