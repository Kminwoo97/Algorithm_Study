class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        int[] pulse = {1,-1};
        for(int i=0; i<sequence.length; i++){
            if(i % 2 == 0){
                sequence[i] *= pulse[0];
            }else{
                sequence[i] *= pulse[1];
            }
        }
        answer = Math.max(answer, twoPointer(sequence));


        for(int i=0; i<sequence.length; i++){
            sequence[i] *= -1;
        }
        answer = Math.max(answer, twoPointer(sequence));


        return answer;
    }

    public long twoPointer(int[] num){
        long answer = 0L;

        long sum = 0L;
        int lt = 0;
        for(int rt=0; rt<num.length; rt++){
            sum += num[rt];

            answer = Math.max(answer, sum);

            while(lt <= rt && sum <= 0){
                sum -= num[lt];
                lt++;
            }
        }

        return answer;
    }
}
