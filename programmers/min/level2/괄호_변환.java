import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        //0.올바른 괄호 or 균형잡힌 괄호인지 판단
        if(Is_RightBracket(p)){
            answer = p;
        }else{        
            answer = Update_RightBracket(p);
        }
        
        return answer;
    }
    
    public boolean Is_RightBracket(String input){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        
        return true;
    }
    
    public int Split_String(String x){
        int a = 0;
        int b = 0;
        for(int i=0; i<x.length(); i++){
            if(x.charAt(i) == '(')
                a += 1;
            else
                b += 1;
            
            if(a == b)
                return i + 1;
        }
        
        return x.length();
    }
    
    public String Update_RightBracket(String x){
        
        //1
        if(x.equals(""))
            return "";
        
        //2
        int split_index = Split_String(x);
        String u = x.substring(0, split_index);
        String v = x.substring(split_index);
        
        //3
        if(Is_RightBracket(u)){
            //3-1
            u += Update_RightBracket(v);
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append('(');//4-1
            sb.append(Update_RightBracket(v));//4-2
            sb.append(')');//4-3

            //4-4
            u = u.substring(1, u.length()-1);
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i) == '(')
                    sb.append(')');
                else
                    sb.append('(');
            }
            
            return sb.toString();
        }
        
        
        return u;
    }
}
