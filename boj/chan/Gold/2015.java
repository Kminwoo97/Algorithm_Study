package org.example.boj;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int sum = 0;
        int[] preSum = new int[n];
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 누적 부분합, 횟수 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            preSum[i] = sum;
        }

        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            answer += map.getOrDefault(preSum[i] - k, 0);
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }

        System.out.println(answer);
    }
}
