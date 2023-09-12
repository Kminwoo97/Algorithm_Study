class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        // dp의 각 요소에는 해당 위치에서 최대로 얻을 수 있는 점수 저장.
        // 이전 위치에서 스티커를 뜯었을 때의 값과, 현재 위치에서 뜯었을 때의 값 중 큰 값을 저장.
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        
        if (sticker.length == 1) {
            return sticker[0];
        }
        
        if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        // 0부터 시작하는 경우
        dp1[0] = sticker[0];
        dp1[1] = Math.max(dp1[0], sticker[1]);
        
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        }
        
        // 1부터 시작하는 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        
        return answer = Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
    }
}
