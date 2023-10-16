class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        
        int lt = 0;
        int sum = 0;
        for(int rt=0; rt<sequence.length; rt++){
            sum += sequence[rt];
            
            while(sum > k){
                sum -= sequence[lt];
                lt++;
            }
            
            if(sum == k){
                if(rt - lt < answer[1] - answer[0]){
                    answer[0] = lt;
                    answer[1] = rt;
                }
            }
        }
        return answer;
    }
}
