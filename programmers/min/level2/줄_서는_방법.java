import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
                
        //숫자 배열 만들기
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        
        k = k - 1;
        for(int i=0; i<answer.length; i++){
            long div_num = factorial(n-1);
            
            int quot = (int)(k / div_num);
            long remain = k % div_num;
            
            answer[i] = list.remove(quot);
            
            k = remain;
            n--;
        }
        
        return answer;
    }
    
    public long factorial(int n){
        long num = 1L;
        for(int i=1; i<=n; i++)
            num *= i;
        return num;
    }
}
