import java.util.*;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Boolean> usedWord = new HashMap<>();
        String preWord = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (!usedWord.containsKey(word)) {
                usedWord.put(word, true);

                if (i > 0 && word.charAt(0) != preWord.charAt(preWord.length() - 1)) {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;

                    break;
                }
            } else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;

                break;
            }

            preWord = word;
        }

        return answer;
    }
}
