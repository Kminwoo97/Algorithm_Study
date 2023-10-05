import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> main = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        
        for(int i=order.length; i>0; i--){
            main.push(i);
        }
        
        int i=0;
        while(true){
            if(!main.isEmpty() && order[i] == main.peek()){
                main.pop();
                answer++;
                i++;
            }else if(!sub.isEmpty() && order[i] == sub.peek()){
                sub.pop();
                answer++;
                i++;
            }else if(!main.isEmpty()){
                sub.push(main.pop());
            }else{
                break;
            }
        }
        
        return answer;
    }
}
