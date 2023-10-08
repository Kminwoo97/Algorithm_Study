import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < ingredient.length; i++) {
            
            if (stack.isEmpty()) {
                stack.push(ingredient[i]);
            } else {
                if (stack.peek() == 3 && ingredient[i] == 1) {
                    int count = 0;
                    StringBuilder sb = new StringBuilder();
                    
                    while (!stack.isEmpty() && count < 3) {
                        sb.append(stack.pop());
                        count++;
                    }
                    
                    if (sb.length() == 3 && sb.toString().equals("321")) {
                        answer++;    
                    } else {
                        for (int j = sb.length() - 1; j >= 0; j--) {
                            stack.push((int) sb.charAt(j));
                        }
                        
                        stack.push(ingredient[i]);
                    }
                } else {
                    stack.push(ingredient[i]);
                }
            }
        }
        
        return answer;
    }
}
