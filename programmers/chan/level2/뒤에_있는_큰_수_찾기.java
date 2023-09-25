import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<int[]> stack = new Stack<>();
                
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < numbers[i]) {
                int[] p = stack.pop();
                answer[p[0]] = numbers[i];
            }
            
            stack.push(new int[]{i, numbers[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            answer[p[0]] = -1;
        }

        return answer;
    }
}
