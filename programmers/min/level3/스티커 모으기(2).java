class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        
        if(n == 1)
            return sticker[0];
        
        //0번 스티커를 뜯은 경우(맨 끝 스티커 못뜯음) -> i번째 스티커를 뜯은 경우, 안뜯은 경우
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for(int i=2; i<n-1; i++){
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
        }
        
        //0번 스티커를 뜯지 않은 경우 -> i번째 스티커를 뜯은 경우, 안뜯은 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<n; i++){
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
        }
        
        answer = Math.max(dp1[n-2], dp2[n-1]);
        return answer;
    }
}
