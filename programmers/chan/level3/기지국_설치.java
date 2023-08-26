class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int i = 0;
        int j = 0;
        
        while (j < stations.length) {
            int tower = stations[j++] - 1; // 타워 위치
            int count = tower - w - i;
            
            if (count > 0) {
                answer += (count - 1) / (w * 2 + 1) + 1;
            }
            
            i = tower + w + 1;
        }
        
        if (i < n) {
            answer += (n - i - 1) / (w * 2 + 1) + 1;
        }

        return answer;
    }
}
