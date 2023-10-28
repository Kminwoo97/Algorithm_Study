package org.example.boj;

import java.io.*;
import java.util.*;

public class p13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] height = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(height);

        List<Integer> heightDiff = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            heightDiff.add(height[i + 1] - height[i]);
        }

        Collections.sort(heightDiff, Comparator.reverseOrder());

        for (int i = k - 1; i < heightDiff.size(); i++) {
            answer += heightDiff.get(i);
        }

        System.out.println(answer);
    }
}
