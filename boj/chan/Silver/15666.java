package org.example.boj;

import java.io.*;
import java.util.*;

public class p15666 {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(arr, new StringBuilder(), m, 0, 0);

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, (e1, e2) -> {
            String[] str1 = e1.split(" ");
            String[] str2 = e2.split(" ");

            for (int i = 0; i < str1.length; i++) {
                if (Integer.parseInt(str1[i]) == Integer.parseInt(str2[i])) {
                    continue;
                }

                return Integer.parseInt(str1[i]) - Integer.parseInt(str2[i]);
            }

            return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
        });

        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void dfs(int[] arr, StringBuilder sb, int m, int index, int count) {

        if (count == m) {
            set.add(sb.toString().substring(0, sb.length() - 1));

            return;
        }

        for (int i = index; i < arr.length; i++) {
            StringBuilder sub = new StringBuilder(sb);
            sub.append(arr[i] + " ");

            dfs(arr, sub, m, i , count + 1);
        }
    }
}
