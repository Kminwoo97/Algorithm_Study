import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        if(s / n == 0){
            answer = new int[]{-1};
        }
        else{
            answer = new int[n];
            for(int i=0; i<answer.length; i++){
                answer[i] = s / n;
                s = s - (s / n);
                n--;
            }
        }
        
        return answer;
    }
    
   
}
