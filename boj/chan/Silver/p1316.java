package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Map<Character, Boolean> map = new HashMap<>();
            boolean isGroupWord = true;

            for (int j = 0; j < str.length(); j++) {
                if (map.containsKey(str.charAt(j))) {
                    if (str.charAt(j - 1) != str.charAt(j)) {
                        isGroupWord = false;
                        break;
                    }
                } else {
                    map.put(str.charAt(j), true);
                }
            }

            if (isGroupWord) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
