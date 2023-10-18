import java.io.*;
import java.util.*;

public class Main {
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] alpha = new String[c];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {
            alpha[i] = st.nextToken();
        }

        Arrays.sort(alpha);

        dfs(l, alpha, new StringBuilder(), -1);

        for (String str : answer) {
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (str.charAt(i) == vowel[j]) {
                        count++;
                    }
                }
            }

            if (count > 0 && count < l - 1) {
                System.out.println(str);
            }
        }
    }

    public static void dfs(int l, String[] alpha, StringBuilder sb, int index) {
        if (sb.length() == l) {
            answer.add(sb.toString());
            return;
        }

        for (int i = index + 1; i < alpha.length; i++) {
            StringBuilder sub = new StringBuilder(sb);
            sub.append(alpha[i]);
            dfs(l, alpha, sub, i);
        }
    }
}
