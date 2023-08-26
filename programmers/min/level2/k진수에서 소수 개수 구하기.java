class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String x = convertK(n, k);
        String[] cadidates = x.split("0");
        for(String strNum : cadidates){
            
            if(strNum.equals(""))
                continue;
            
            //n을 String형태의 k진수로 변환하고 다시 숫자로 변환할 때 int 범위를 넘어간다. 따라서 Long 사용
            Long num = Long.parseLong(strNum);
            if(num > 1){   
                if(IsPrime(num)){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public String convertK(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        while(n / k > 0){
            sb.append(n % k);
            n = n / k;
        }
        sb.append(n);
        
        return sb.reverse().toString();
    }
    
    public boolean IsPrime(Long num){
        
        boolean flag = true;
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num % i == 0){
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}
