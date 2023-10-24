package org.example.boj;

import java.io.*;
import java.util.*;

public class p1010 {
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp = new long[30][30];

        for (int i = 1; i < 30; i++) {
            dp[1][i] = i;
        }

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= m; k++) {
                    dp[j][k] = memoization(j, k);
                }
            }

            System.out.println(dp[n][m]);
        }
    }

    public static long memoization(int a, int b) {
        if (dp[a][b] != 0) return dp[a][b];

        for (int i = b - 1; i >= a - 1; i--) {
            dp[a][b] += recursive(a - 1, i);
        }

        return dp[a][b];
    }

    public static long recursive(int a, int b) {
        if (dp[a][b] != 0) return dp[a][b];

        return dp[a][b] = memoization(a, b);
    }
}
