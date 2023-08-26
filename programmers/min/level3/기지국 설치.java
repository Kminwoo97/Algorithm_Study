class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        
        int cnt = 0;
        for(int i=0; i<stations.length; i++){
            if(i == 0){
                //1 <= x < stations[i] - w
                cnt = (stations[i] - w) - 1;
            }else{
                //stations[i-1] + w < x < stations[i] - w
                cnt = (stations[i] - w) - (stations[i-1] + w) - 1;
            }
            
            //기지국 설치
            if(cnt > 0){
                if(cnt % (w * 2 + 1) == 0)
                    answer += (cnt / (2 * w + 1));
                else
                    answer += (cnt / (2 * w + 1)) + 1;
            }
        }
        
        //마지막 구간 -> stations[stations.length - 1] + w < x <= n
        cnt = n - (stations[stations.length - 1] + w);
        if(cnt > 0){
            if(cnt % (w * 2 + 1) == 0)
                answer += (cnt / (w * 2 + 1));
            else
                answer += (cnt / (w * 2 + 1)) + 1;
        }

        return answer;
    }
}
