class Solution {
    public int solution(int n, int m, int[] section) {
        int roller = section[0];
        int cnt = 1;
        for(int i = 1; i < section.length; i++) {
            //현재 룰러의 끝위치 < 보고있는 칠해야하는 구역
            if(roller + m - 1 < section[i]) {
                cnt++;
                roller = section[i];
            }
        }
        return cnt;
    }
}

