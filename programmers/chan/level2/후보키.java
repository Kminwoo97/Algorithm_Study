import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < relation.length; i++) {
            dfs(map, relation[i], new StringBuilder(), 0);
        }
        
        List<String> keys = new ArrayList<>(map.keySet());
        
        for (String key : keys) {
            if (map.get(key) != 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(Map<String, Integer> map, String[] tuple, StringBuilder sb, int start) {
        for (int i = start; i < tuple.length; i++) {
            StringBuilder sub = new StringBuilder(sb);
            sub.append(tuple[i]);
            map.put(sub.toString(), map.getOrDefault(sub.toString(), 0) + 1);
            dfs(map, tuple, sub, i + 1);
        }
    }
}
