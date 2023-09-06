import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        // n 진수로 변환하는 함수
        // 0 ~ t 번까지 튜브가 말할 숫자. => answer
        // 튜브의 순서 p. 총 m 명이 참가하게 된다.
        // 숫자를 String으로 변환한 총 길이가 t * m 일때까지만 구한다. -> 총 길이를 받는 변수,.. for문.. 
        int number = 0;
        int len = t * m;
        StringBuilder sb = new StringBuilder();
        StringBuilder sub = new StringBuilder();
        
        while (sb.length() < len) {
            sb.append(getNumberToString(number++, n)); // 숫자변환 후 변환된 숫자를 sb에 추가
            // sb가 t * m보다 커지면 종료.
            // 이제 이 sb에서 튜브가 말할 숫자들만 뽑아준다.
        }
        
        for (int i = p - 1; i < len; i += m) {
            sub.append(sb.charAt(i));
        }
        
        return answer = sub.toString();
    }
    
    public String getNumberToString(int number, int n) {
        // n 진수로 변환해서 String으로 반환
        StringBuilder sb = new StringBuilder();
        
        if (number == 0) {
            return "0";
        }
        
        while (number > 0) {
            int remain = number % n;
            
            if (remain >= 10) {
                sb.append((char) (remain + 55));
            } else {
                sb.append(remain);
            }
            
            number /= n;
        }
        
        return sb.reverse().toString();
    }
}
