import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String convertK= convert(n, k);
        String[] split = convertK.split("0");
        ArrayList<String> list = new ArrayList<>();
        for(String x : split){
            if(!x.isEmpty())
                list.add(x);
        }
        
        
        for(String numK : list){
            if(numK.equals("1"))
                continue;
            
            //범위를 벗어나기 떄문에 Long
            long x = Long.parseLong(numK);
            boolean flag = true;
            
            for(long i=2; i<=(long)Math.sqrt(x); i++){
                if(x % i == 0){
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                answer++;
        }
        
        
        
        return answer;
    }
    
    public String convert(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        if (n == 0) 
            return "0";
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
}
