class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        //arrayA, arrayB 최대 공약수 구하기
        int gcd_a = arrayA[0];
        for(int i=1; i<arrayA.length; i++){
            gcd_a = getGCD(gcd_a, arrayA[i]);
        }
        
        int gcd_b = arrayB[0];
        for(int i=1; i<arrayB.length; i++){
            gcd_b = getGCD(gcd_b, arrayB[i]);
        }
        
        //arrayB[i]가 GCD_A에 나눠떨어지는지 체크
        if(gcd_a != 1){
            boolean flag = true;
            for(int i=0; i<arrayB.length; i++){                
                if(arrayB[i] % gcd_a== 0){
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                answer = Math.max(answer, gcd_a);
        }
       
        //arrayA[i]가 GCD_B에 나눠떨어지는지 체크
        if(gcd_b != 1){
            boolean flag = true;
            for(int i=0; i<arrayA.length; i++){
                if(arrayA[i] % gcd_b == 0){
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                answer = Math.max(answer, gcd_b);
        }
      
        
        return answer;
    }
    
    public int getGCD(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
