package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14501 {
    static int profit = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dfs(n, t, p, isVisited, new int[]{0, 0, 0});

        System.out.println(profit);
    }

    public static void dfs(int n, int[] t, int[] p, boolean[] isVisited, int[] cur) {
        if (cur[1] > n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i + 1 <= cur[1]) {
                continue;
            }

            int[] next = new int[]{i + 1, i + t[i], cur[2] + p[i]};

            if (next[1] <= n && isVisited[i] == false) {
                isVisited[i] = true;
                profit = Math.max(profit, next[2]);

                dfs(n, t, p, isVisited, next);
                isVisited[i] = false;
            }
        }
    }
}
