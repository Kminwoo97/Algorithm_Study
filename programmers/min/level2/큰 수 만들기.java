import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int cnt = 0;
        Stack<String> stack = new Stack<>();
        String[] numbers = number.split("");
        for(int i=0; i<numbers.length; i++){
            while(!stack.isEmpty() && Integer.parseInt(stack.peek()) < Integer.parseInt(numbers[i]) && cnt < k){
                stack.pop();
                cnt++;
            }
            stack.push(numbers[i]);
        }
        
        while(cnt < k){
            stack.pop();
            cnt++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString();
        
        return answer;
    }
}
