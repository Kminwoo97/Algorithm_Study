import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();        
            
        // k 진수로 변환
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                stack.push(sb.charAt(i));
            } 
            
            if (sb.charAt(i) == '0' || i == sb.length() - 1) {
                StringBuilder sub = new StringBuilder();
                
                while (!stack.isEmpty()) {
                    sub.append(stack.pop());
                }
                
                // 소수 판별
                if (!sub.toString().equals("") && isPrimeNumber(sub) == true) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrimeNumber(StringBuilder sub) {
        long number = Long.parseLong(sub.toString());

        if (number == 1) {
            return false;
        }
        
        for (long i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
