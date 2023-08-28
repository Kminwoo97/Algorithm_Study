class Solution {

    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        
        int[] count = new int[number + 1];
        for(int i=1; i<=number; i++){
            //효율적인 약수 개수 구하는 알고리즘
            for(int j=1; j<=(int)Math.sqrt(i); j++){
                if(j * j == i)
                    count[i] += 1;
                else if(i % j == 0)
                    count[i] += 2;
            }
        }
        
        for(int i=1; i<=number; i++){
            if(count[i] > limit)
                answer += power;
            else
                answer += count[i];
        }
        
        return answer;
    }
}
