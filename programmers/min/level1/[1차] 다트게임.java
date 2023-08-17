import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String[] dart = dartResult.split("");
        int[] ans = new int[3];
        int idx = 0;
        String tmp = "";
        for(int i=0; i<dart.length; i++){
            switch(dart[i]){
                case "S":
                    ans[idx] = (int)Math.pow(Integer.parseInt(tmp),1);
                    idx++;
                    tmp = "";
                    break;
                    
                case "D":
                    ans[idx] = (int)Math.pow(Integer.parseInt(tmp),2);
                    idx++;
                    tmp = "";
                    break;
                    
                case "T":
                    ans[idx] = (int)Math.pow(Integer.parseInt(tmp),3);
                    idx++;
                    tmp = "";
                    break;
                    
                case "*":
                    ans[idx-1] *= 2;
                    if(idx-1 >= 1) //-> 바로 직전의 점수 2배
                        ans[idx-2] *= 2;
                    break;
                    
                case "#":
                    ans[idx-1] *= -1;
                    break;
                    
                default:
                    tmp += dart[i];
                    break;
            }
        }
        
        for(int x : ans){
            answer += x;
        }
        
        return answer;
    }
}
