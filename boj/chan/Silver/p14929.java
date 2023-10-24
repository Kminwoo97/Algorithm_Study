package org.example.boj;

import java.io.*;
import java.util.*;

public class p14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] preSum = new int[n];
        int sum = 0;
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            sum += x[i];
            preSum[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            answer += x[i] * (preSum[n - 1] - preSum[i]);
        }

        System.out.println(answer);
    }
}
