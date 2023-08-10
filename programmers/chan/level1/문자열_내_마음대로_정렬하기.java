import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            strings[i].charAt(n);
        }

        answer = Arrays.stream(strings)
                .sorted((e1, e2) -> {
                    if (e1.charAt(n) == e2.charAt(n)) {
                        return e1.compareTo(e2);
                    }

                    return Character.compare(e1.charAt(n), e2.charAt(n));
                })
                .toArray(String[]::new);

        return answer;
    }
}