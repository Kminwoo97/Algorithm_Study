class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        //페인트 칠해야 하는 구역
        boolean[] ispaint = new boolean[n+1];
        int[] paints = new int[n+1];
        for(int x : section){
            paints[x] = 1;
            ispaint[x] = true;
        }

        for(int i=1; i<=n; i++){
            if(ispaint[i] && paints[i] == 1){
                if(i + m > n){
                    for(int j=i; j<=n; j++){
                        paints[j]--;
                    }
                }else{
                    for(int j=i; j<i+m; j++){
                        paints[j]--;
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}
