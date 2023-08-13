class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            
            //제곱근의 성질을 이용한 약수 개수 구하기
            int tmp = 0;
            for(int j=1; j<=(int)Math.sqrt(i); j++){
                if(j * j == i)
                    tmp++;
                else if(i % j == 0)
                    tmp += 2;
            }
            
            if(tmp > limit)
                answer += power;
            else
                answer += tmp;
        }
        
        return answer;
    }
}
