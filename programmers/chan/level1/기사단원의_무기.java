class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int div = getDiv(i);
            
            if (div > limit) {
                div = power;
            }
            
            answer += div;
        }
        
        return answer;
    }
    
    public int getDiv(int n) {
        int count = 0;
        int index = 0;
        
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            
            if (i * i == n) {
                index = i;
            }
        }
        
        count *= 2;
        
        if (index != 0) {
            count--;
        }
        
        return count;
    }
}
