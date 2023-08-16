import java.util.*;

class Solution {
    static Queue<String> queue = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            answer += add(cities[i].toLowerCase(), cacheSize);
        }

        return answer;
    }

    public int add(String str, int cacheSize) {
        int size = queue.size();
        boolean isContainStr = false;
        String recentlyUsedStr = "";

        for (int i = 0; i < size; i++) {
            String p = queue.poll();

            if (p.equals(str)) {
                isContainStr = true;
                recentlyUsedStr = p;
                continue;
            }

            queue.offer(p);
        }

        if (isContainStr == true) {
            queue.offer(recentlyUsedStr);
            return 1;
        } else {
            queue.offer(str);

            if (queue.size() > cacheSize) {
                queue.poll();
            }

            return 5;
        }
    }
}