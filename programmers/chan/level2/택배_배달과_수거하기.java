class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del = 0; // 배달 가능한 용량
        int pic = 0; // 수거 가능한 용량
            
        for (int i = n - 1; i >= 0; i--) {
            del -= deliveries[i];
            pic -= pickups[i];
            
            // 물류창고로 복귀 후 다시 현 위치로 와야하는 경우
            while (del < 0 || pic < 0) {
                del += cap;
                pic += cap;
                
                answer += (i + 1) * 2;
            }
        }
        
        return answer;
    }
}
