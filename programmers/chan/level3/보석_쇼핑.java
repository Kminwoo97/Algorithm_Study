import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        
        for (String gem : gems) {
            set.add(gem);
        }
        
        int kind = set.size();
        
        Map<String, Integer> map = new HashMap();
        int start = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            // 뒤에서 보석이 추가로 나올 경우 start를 이동시킴
            while (map.get(gems[start]) > 1) { 
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            // 모든 종류의 보석이 나온 경우
            if (map.size() == kind && min > (i - start)) {
                min = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }
        
        return answer;
    }
}
