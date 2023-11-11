class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int remain = storey % 10;
            
            //나머지가 6이상, 4이하, 5인 3가지 경우를 생각한다.
            if(remain >= 6){
                storey += (10 - remain);
                answer += (10 - remain);
            }else if(remain <= 4){
                storey -= remain;
                answer += remain;
                
            }else if(remain == 5){
                //나머지가 5이면 앞의 자리를 확인해야한다.
                
                //앞의 자리가 존재하지 않는다 -> 즉, 1자리 숫자라는 것이다.
                if((storey / 10) % 10 == 0){
                    storey -= remain;
                    answer += remain;
                }else{
                    //앞의 자리가 5보다 작으면 빼준다.
                    //앞의 자리가 5이상이면 더해준다.
                    if((storey / 10) % 10 < 5){
                        storey -= remain;
                        answer += remain;
                    }else{
                        storey += remain;
                        answer += remain;
                    }
                }
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
