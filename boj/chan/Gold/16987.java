package org.example.boj;

import java.io.*;
import java.util.*;

public class p16987 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] durability = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(durability, weight, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int[] durability, int[] weight, int start, int count) {

        if (start >= weight.length || count >= weight.length - 1) {
            answer = Math.max(answer, count);
            return;
        }

        if (durability[start] <= 0) {
            dfs(durability, weight, start + 1, count);
            return;
        }

        for (int i = 0; i < weight.length; i++) {
            if (i == start) {
                continue;
            }

            if (durability[i] > 0) {
                durability[i] -= weight[start];
                durability[start] -= weight[i];

                if (durability[start] <= 0 && durability[i] <= 0) {
                    dfs(durability, weight, start + 1, count + 2);
                } else if (durability[start] > 0 && durability[i] > 0) {
                    dfs(durability, weight, start + 1, count);
                } else {
                    dfs(durability, weight, start + 1, count + 1);
                }

                durability[i] += weight[start];
                durability[start] += weight[i];
            }
        }
    }
}
