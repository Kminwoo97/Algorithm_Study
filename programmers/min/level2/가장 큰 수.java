import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strNumbers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        //숫자를 이어붙였을 때, 더 큰 수를 기준으로 정렬
        Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b));
        
        //[0,0,0,0] 인 경우는 정답이 "0"이다.
        if(strNumbers[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strNumbers.length; i++){
            sb.append(strNumbers[i]);
        }
        answer = sb.toString();
        
        return answer;
    }
}
