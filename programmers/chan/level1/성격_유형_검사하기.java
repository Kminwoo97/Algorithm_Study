import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + choices[i] - 4);
            }
        }
        
        answer += getPersonalityType(map, 'R', 'T'); 
        answer += getPersonalityType(map, 'C', 'F');
        answer += getPersonalityType(map, 'J', 'M');
        answer += getPersonalityType(map, 'A', 'N');
        
        return answer;
    }
            
    public char getPersonalityType(Map<Character, Integer> map, char a, char b) {
        if (map.getOrDefault(a, 0) > map.getOrDefault(b, 0)) {
            return a;
        } else if (map.getOrDefault(a, 0) < map.getOrDefault(b, 0)) {
            return b;
        } else {
            return a;
        }
    }
}
