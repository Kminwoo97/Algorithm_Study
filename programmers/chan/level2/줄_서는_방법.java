import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        int index = 0;
        
        while (n > 0) {
            long fac = factorial(n - 1);
            int quot = (int) ((k - 1) / fac);
            k = (k - 1) % fac + 1;
            answer[index++] = list.get(quot);
            list.remove(quot);

            n--;
        }
        
        for (int i = 0; i < list.size(); i++) {
            answer[index + i] = list.get(i);
        }
        
        return answer;
    }
    
    public long factorial(int n) {
        long sum = 1;
        
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        
        return sum;
    }
}
