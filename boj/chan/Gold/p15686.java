package org.example.boj;

import java.io.*;
import java.util.*;

public class p15686 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        List<int[]> homes = new ArrayList<>();
        List<int[]> chickens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    homes.add(new int[]{i, j});
                }

                if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        dfs(m, 0, 0, homes, chickens, new boolean[chickens.size()]);

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int m, int count, int idx, List<int[]> homes, List<int[]> chickens, boolean[] isVisited) {

        if (count == m) {
            int sum = 0;

            for (int i = 0; i < homes.size(); i++) {
                int[] home = homes.get(i);
                int dist = Integer.MAX_VALUE;

                for (int j = 0; j < chickens.size(); j++) {
                    int[] point = chickens.get(j);

                    if (isVisited[j] == true) {
                        dist = Math.min(dist, Math.abs(home[0] - point[0]) + Math.abs(home[1] - point[1]));
                    }
                }

                sum += dist;

                if (sum > answer) {
                    return;
                }
            }

            answer = Math.min(answer, sum);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                dfs(m, count + 1, i + 1, homes, chickens, isVisited);
                isVisited[i] = false;
            }
        }
    }
}
