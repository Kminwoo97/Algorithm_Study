import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            // 안 입는 경우의 수 포함
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        List<String> keys = new ArrayList<>(map.keySet());

        for (String key : keys) {
            answer *= map.get(key);
        }
        
        // 아무것도 안 입는 경우 제외
        return answer - 1;
    }
}
