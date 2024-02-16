import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}

// stack 사용한 코드

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        int len = prices.length - 1;
        
        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] pre = stack.pop();
                
                answer[pre[0]] = i - pre[0];
            }
        
            stack.push(new int[]{i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            
            answer[cur[0]] = len - cur[0];
        }
        
        return answer;
    }
}
