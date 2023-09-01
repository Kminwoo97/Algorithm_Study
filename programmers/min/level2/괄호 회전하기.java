import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            
            for(int j=0; j<s.length(); j++){
                char x = s.charAt((i+j) % s.length());
                
                if(x == '(' || x == '{' || x == '['){
                    stack.push(x);
                }else{
                    if(!stack.isEmpty()){
                        if(x == ')' && stack.peek() == '('){
                           stack.pop();
                        }
                        
                        if(x == '}' && stack.peek() == '{'){
                           stack.pop();
                        } 
                        
                        if(x == ']' && stack.peek() == '['){
                           stack.pop();
                        } 
                    }else{
                        stack.push(x);
                    }
                }
            }
            
            if(stack.isEmpty())
                answer++;
            
        }
        
        return answer;
    }
}
