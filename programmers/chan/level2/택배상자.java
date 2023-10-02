import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        int num = 1;
        
        while (num <= order.length && i < order.length) {
            if (order[i] == num) {
                answer++;
                i++;
                num++;
            } else {
                if (stack.isEmpty()) {
                    stack.push(num);
                    num++;
                    continue;
                }

                if (order[i] == stack.peek()) {
                    stack.pop();
                    answer++;
                    i++;
                } else {
                    if (num >= order.length) {
                        break;
                    } else {
                        stack.push(num++);
                    }
                }
            }
        }
        
        while (!stack.isEmpty() && i < order.length) {
            int p = stack.pop();
            
            if (p == order[i++]) {
                answer++;
                continue;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
