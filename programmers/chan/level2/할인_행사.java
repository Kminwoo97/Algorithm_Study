import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> map = new HashMap<>();
            
            for (int j = 0; j < want.length; j++) {
                map.put(want[j], number[j]);
            }
            
            int count = map.size();
            
            for (int j = i; j < i + 10; j++) {
                if (map.containsKey(discount[j])) {
                    int value = map.get(discount[j]);
                    
                    if (value == 1) {
                        count--;
                    }
                    
                    map.put(discount[j], value - 1);
                }
            }
            
            if (count == 0) {
                list.add(0);
            }
        }
        
        return answer = list.size();
    }
}
