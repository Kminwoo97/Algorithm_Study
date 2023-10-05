import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] isVisited;
    
    public int solution(String numbers) {
        int answer = 0;
        isVisited = new boolean[numbers.length()];
        
        StringBuilder sb = new StringBuilder();
        getNumber(numbers, sb);
        
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void getNumber(String numbers, StringBuilder sb) {
        if (sb.length() != 0) {
            set.add(Integer.parseInt(sb.toString()));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (isVisited[i] == false) {

                isVisited[i] = true;
                
                StringBuilder sub = new StringBuilder(sb);
                sub.append(numbers.charAt(i));
            
                getNumber(numbers, sub);
                isVisited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        if (n == 2) {
            return true;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
