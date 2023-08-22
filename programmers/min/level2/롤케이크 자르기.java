import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //초기에는 철수가 토핑을 모두 가져간다.
        Map<Integer, Integer> mapA = new HashMap<>();
        for(int x : topping){
            mapA.put(x, mapA.getOrDefault(x, 0) + 1);
        }
        
        //동생이 한개씩 가져간다. 그리고 토핑의 개수를 비교한다.
        Map<Integer, Integer> mapB = new HashMap<>();
        for(int i=0; i<topping.length; i++){
            int key = topping[i];
            mapB.put(key, mapB.getOrDefault(key, 0) + 1);
            
            if(mapA.get(key) == 1){
                mapA.remove(key);
            }else{
                mapA.put(key, mapA.get(key)-1);
            }
            
            if(mapA.size() == mapB.size())
                answer++;
        }
        
        
        return answer;
    }
}
