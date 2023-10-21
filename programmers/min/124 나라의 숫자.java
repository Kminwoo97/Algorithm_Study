import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        //1%3 = 1 (1)
        //2%3 = 2 (2)
        //3%3 = 0 (4)
        String[] remain = {"4", "1", "2"};
        
        
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(remain[n % 3]);
            
            //3의 배수는 계산을 한번 더 하게 만든다. 따라서 -1
            if(n % 3 == 0)
                n--;
            
            n /= 3;
        }
        
        answer = sb.reverse().toString();

        return answer;
    }
}
