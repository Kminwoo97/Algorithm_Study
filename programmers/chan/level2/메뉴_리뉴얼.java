import java.util.*;

class Solution {
    static Map<String, Integer>[] maps;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> answers = new ArrayList<>();
        maps = new Map[11];
        
        for (int i = 1; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                dfs(course[i], new StringBuilder(), orders[j], -1);
            }
            
            Map<String, Integer> map = maps[course[i]];
            List<String> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys, (e1, e2) -> map.get(e2) - map.get(e1));
            
            if (keys.size() > 0) {
                int max = map.get(keys.get(0));
                
                if (max > 1) {
                    for (String key : keys) {
                        if (max == map.get(key)) {
                            answers.add(key);
                        }
                    }
                }
            }
        }
        
        Collections.sort(answers);
        
        answer = new String[answers.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answers.get(i);    
        }
        
        return answer;
    }
    
    public void dfs(int n, StringBuilder sb, String str, int index) {
        if (sb.length() == n) {
            char[] chars = sb.toString().toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            
            maps[n].put(newStr, maps[n].getOrDefault(newStr, 0) + 1);
            return;
        }
        
        for (int i = index + 1; i < str.length(); i++) {
            StringBuilder sub = new StringBuilder(sb);
            sub.append(str.charAt(i));

            dfs(n, sub, str, i);
        }
    }
}
