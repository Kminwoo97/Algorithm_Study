import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> person = new HashMap<>();
        Map<Integer, Integer> multi = new HashMap<>();
        
        for (int i = 0; i < weights.length; i++) {
            int dupledPerson = person.getOrDefault(weights[i], 0); // 몸무게 중복인 사람의 수
            int m2 = weights[i] * 2;
            int m3 = weights[i] * 3;
            int m4 = weights[i] * 4;
            
            if (dupledPerson > 0) {
                answer += dupledPerson;
                answer += multi.getOrDefault(m2, 0) - dupledPerson;
                answer += multi.getOrDefault(m3, 0) - dupledPerson;
                answer += multi.getOrDefault(m4, 0) - dupledPerson;
            } else {
                answer += multi.getOrDefault(m2, 0);
                answer += multi.getOrDefault(m3, 0);
                answer += multi.getOrDefault(m4, 0);
            }
            
            person.put(weights[i], person.getOrDefault(weights[i], 0) + 1);
            multi.put(m2, multi.getOrDefault(m2, 0) + 1);
            multi.put(m3, multi.getOrDefault(m3, 0) + 1);
            multi.put(m4, multi.getOrDefault(m4, 0) + 1);
        }
        
        return answer;
    }
}
