import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> weightsMap = new HashMap<>();
        
        for (int i = 0; i < weights.length; i++) {
            int doubleW = weights[i] * 2;
            int tripleW = weights[i] * 3;
            int quadrupleW = weights[i] * 4;
            
            // 몸무게 같은 경우
            if (weightsMap.containsKey(weights[i])) {
                int value = weightsMap.get(weights[i]);
                answer += value;
                answer += map.getOrDefault(doubleW, 0) - value;
                answer += map.getOrDefault(tripleW, 0) - value;
                answer += map.getOrDefault(quadrupleW, 0) - value;
                
            } else {                
                answer += map.getOrDefault(doubleW, 0);
                answer += map.getOrDefault(tripleW, 0);
                answer += map.getOrDefault(quadrupleW, 0);
            }
            
            weightsMap.put(weights[i], weightsMap.getOrDefault(weights[i], 0) + 1);
            map.put(doubleW, map.getOrDefault(doubleW, 0) + 1);
            map.put(tripleW, map.getOrDefault(tripleW, 0) + 1);
            map.put(quadrupleW, map.getOrDefault(quadrupleW, 0) + 1);
        }
        
        return answer;
    }
}
