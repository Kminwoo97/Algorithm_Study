import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char ch = keymap[i].charAt(j);
                int index = map.getOrDefault(ch, j);
                
                if (index >= j) {
                    index = j;
                    
                    map.put(ch, index);
                } else {
                    continue;
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                char target = targets[i].charAt(j);
                
                if (map.containsKey(target)) {
                    answer[i] += map.get(target) + 1;
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
