import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Mandarin> list = new ArrayList<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            
            list.add(new Mandarin(key, value));
        }
        
        Collections.sort(list, (e1, e2) -> e2.quantity - e1.quantity);
        
        int index = 0;
        while (k > 0) {
            Mandarin mandarin = list.get(index++);
            k -= mandarin.quantity;
        }
        
        return answer = index;
    }
}

class Mandarin {
    int num;
    int quantity;
    
    Mandarin (int num, int quantity) {
        this.num = num;
        this.quantity = quantity;
    }
}
