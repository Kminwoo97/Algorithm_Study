package org.example.boj;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class p9095 {
    static int[] num = {1, 2, 3};
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            set = new HashSet<>();

            dfs(n, 0, new StringBuilder());

            System.out.println(set.size());
        }
    }

    public static void dfs(int n, int sum, StringBuilder sb) {
        if (sum == n) {
            set.add(sb.toString());
        }

        for (int i = 0; i < 3; i++) {
            if (sum + num[i] <= n) {
                StringBuilder sub = new StringBuilder(sb);
                sub.append(num[i]);

                dfs(n, sum + num[i], sub);
            }
        }
    }
}
