package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Integer.MIN_VALUE;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + map[i][j] - dp[i - 1][j - 1];
            }
        }

        for (int i = n; i > 0; i--) {
            for (int j = m; j > 0; j--) {
                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        answer = Math.max(answer, dp[i][j] - (dp[k - 1][j] + dp[i][l - 1] - dp[k - 1][l - 1]));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
