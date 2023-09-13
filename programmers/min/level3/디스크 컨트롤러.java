import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //요청이 들어온 순서대로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        //작업의 처리시간 기준으로 최소힙
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        
        int i = 0;
        int cnt = 0;
        int curTime = 0;
        while(cnt < jobs.length){
            //작업넣기
            while(i < jobs.length && jobs[i][0] <= curTime){
                pq.offer(jobs[i]);
                i++;
            }
            
            //작업처리
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                curTime = curTime + job[1]; //현재시간 갱신
                answer += (curTime - job[0]); //총 소요시간
                cnt++;
            }else{
                curTime++;
            }
        }
        
        answer = answer / jobs.length;
        
        return answer;
    }
}
