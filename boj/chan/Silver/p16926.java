package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            rotate(map, new int[]{map.length, map[0].length}, new int[]{0, 0});
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void rotate(int[][] map, int[] len, int[] start) {
        // 재귀형태로, start 지점 파라미터로 받기
        int n = len[0] - 1;
        int m = len[1] - 1;

        if (n < 1 || m < 1) {
            return;
        }

        int pre = map[start[0]][start[1]];
        int cur = 0;

        for (int i = 1; i <= n; i++) {
            cur = map[start[0] + i][start[1]];
            map[start[0] + i][start[1]] = pre;
            pre = cur;
        }

        for (int i = 1; i <= m; i++) {
            cur = map[start[0] + n][start[1] + i];
            map[start[0] + n][start[1] + i] = pre;
            pre = cur;
        }

        for (int i = 1; i <= n; i++) {
            cur = map[start[0] + n - i][start[1] + m];
            map[start[0] + n - i][start[1] + m] = pre;
            pre = cur;
        }

        for (int i = 1; i <= m; i++) {
            cur = map[start[0]][start[1] + m - i];
            map[start[0]][start[1] + m - i] = pre;
            pre = cur;
        }

        rotate(map, new int[]{len[0] - 2, len[1] - 2}, new int[]{start[0] + 1, start[1] + 1});
    }
}
