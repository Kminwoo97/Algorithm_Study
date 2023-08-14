import java.util.*;

class [3차]_압축 {
    public int[] solution(String msg) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 27; i++) {
            String alpha = String.valueOf((char)(i + 64));
            dictionary.put(alpha, i);
        }

        int start = 0;
        int end = 0;

        while(end < msg.length()) {
            if (!dictionary.containsKey(msg.substring(start, ++end))) {
                dictionary.put(msg.substring(start, end), dictionary.size() + 1);
                list.add(dictionary.get(msg.substring(start, --end)));
                start = end;
            }
        }

        list.add(dictionary.get(msg.substring(start, end)));

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}