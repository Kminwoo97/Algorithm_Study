import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //차량 나가는 시간을 기준으로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        int camera = Integer.MIN_VALUE;
        for(int[] route : routes){
            if(camera < route[0]){
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}
