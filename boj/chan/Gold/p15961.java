package org.example.boj;

import java.util.*;
import java.io.*;

public class p15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] dishes = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = left + k - 1;
        int count = 0;
        int answer = 0;

        for (int i = 0; i < k; i++) {
            int value = map.getOrDefault(dishes[i], 0);

            map.put(dishes[i], value + 1);

            if (value == 0) {
                count++;
            }
        }

        answer = count;

        while (left < n) {
            int leftValue = map.getOrDefault(dishes[left - 1], 0);

            if (leftValue == 1) {
                count--;
            }

            map.put(dishes[left - 1], leftValue - 1);

            int value = map.getOrDefault(dishes[right % n], 0);

            if (value < 1) {
                count++;
            }

            map.put(dishes[right % n], value + 1);

            if (map.getOrDefault(c, 0) < 1) {
                answer = Math.max(answer, count + 1);
            } else {
                answer = Math.max(answer, count);
            }

            left++;
            right++;
        }

        System.out.println(answer);
    }
}
