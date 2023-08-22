import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int total = 0;
        Set<Integer> set= new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        total = set.size();
        set = new HashSet<>();
        
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            int value = map.get(topping[i]);
            
            map.put(topping[i], value - 1);
            
            if (value == 1) {
                total--;
            }
            
            if (set.size() == total) {
                answer++;
            }
        }
        
        
        return answer;
    }
}
