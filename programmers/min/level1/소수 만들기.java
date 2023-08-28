class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        //에라토스테네스의 체
        //문제에서 3개의 숫자 최대합 -> 1000 + 999 + 998 =  2998
        int[] prime = new int[2999];
        for(int i=2; i<=2998; i++){
            if(prime[i] == 0){
                for(int j=i+i; j<=2998; j+=i){
                    prime[j] = 1;
                }
            }
        }
        
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int x = nums[i] + nums[j] + nums[k];
                    if(prime[x] == 0)
                        answer++;
                }
            }
        }
        

        return answer;
    }
}
