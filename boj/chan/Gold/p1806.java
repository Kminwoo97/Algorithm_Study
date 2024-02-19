package org.example.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1806 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (start <= n && end <= n) {
            if (sum < s) {
                sum += arr[end++];
            } else {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        System.out.println(min);
    }
}
