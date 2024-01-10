class Solution {
    
    public long solution(int[] weights) {
        long answer = 0;
        
        int[] person = new int[1001];
        int[] person_mul = new int[4001];
        
        for(int i=0; i<weights.length; i++){
            int w = weights[i];
            
            int mul_2 = w * 2;
            int mul_3 = w * 3;
            int mul_4 = w * 4;
            
            if(person[w] > 0){
                //몸무게가 같은 사람이 있는 경우
                answer += person[w];
                
                answer += person_mul[mul_2] - person[w];
                answer += person_mul[mul_3] - person[w];
                answer += person_mul[mul_4] - person[w];
            }else{
                //몸무게가 같은 사람이 아닌 경우
                answer += person_mul[mul_2];
                answer += person_mul[mul_3];
                answer += person_mul[mul_4];
            }
        
            person[w]++;
            person_mul[mul_2]++;
            person_mul[mul_3]++;
            person_mul[mul_4]++;
        }
        
        return answer;
    }
}
