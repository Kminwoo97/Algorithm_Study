import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clo : clothes){
            String type = clo[1];
            String item = clo[0];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for(String key : map.keySet()){
            //아무것도 입지 않은 경우 +1
            answer *= (map.get(key) + 1);
        }
        
        //아무것도 입지 않은 경우
        answer -= 1;
        return answer;
    }
}
