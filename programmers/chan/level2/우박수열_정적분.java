import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        // 콜라츠 추측을 통해 1이 되는 점을 구해서 List로 반환
        List<Integer> list = collatz(k);
        
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1];
            
            // 정적분 계산
            answer[i] = integralCalc(list, start, list.size() - 1 + end);
        }
        
        return answer;
    }
    
    public List<Integer> collatz(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(k);
        
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            
            list.add(k);
        }
        
        return list;
    }
    
    public double integralCalc(List<Integer> list, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        double result = 0.0D;
        
        if (start > end) {
            return -1.0D;
        } 
        
        for (int i = start; i <= end; i++) {
            int cur = list.get(i);
            
            if (queue.isEmpty()) {
                queue.add(cur);
            } else {
                int pre = queue.poll();
                result += (pre + cur) * 0.5;
                queue.add(cur);
            }
        }
        
        
        return result;
    }
}
