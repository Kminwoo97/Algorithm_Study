import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            map1.put(participant[i], map1.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            map2.put(completion[i], map2.getOrDefault(completion[i], 0) + 1);
        }
        
        List<String> list = new ArrayList<>(map1.keySet());
        
        for (String key : list) {
            int participantNameCount = map1.get(key);
            int completionNameCount = map2.getOrDefault(key ,0);
            
            if (participantNameCount != completionNameCount) {
                answer = key;
            }
        }
        
        return answer;
    }
}
