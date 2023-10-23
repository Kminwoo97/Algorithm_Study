package org.example.boj;

import java.util.*;
import java.io.*;

public class p12933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sounds = "quack";
        String n = br.readLine();
        int answer = 0;
        boolean[] isChecked = new boolean[n.length()];

        if (n.length() % 5 != 0) {
            answer = -1;
        } else {
            while (true) {
                int i = 0;
                int j = 0;
                int count = 0;

                while (j < n.length()) {
                    if (isChecked[j] == true) {
                        count++;
                    }

                    if (isChecked[j] == false && sounds.charAt(i % 5) == n.charAt(j)) {
                        isChecked[j] = true;
                        i++;
                        j++;
                    } else {
                        j++;
                    }
                }

                if (i / 5 > 0) {
                    answer++;
                } else {
                    if (count == n.length()) {
                        break;
                    }

                    answer = -1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
