import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int endTime = 0; // 작업 종료시간
        int total = 0;
        int index = 0;
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 작업시간이 짧은 순으로 처리
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        while (count < jobs.length) {
            int waiting = 0;
            
            // 현재 작업이 끝나기 전에 들어오는 작업들을 pq에 넣음.
            while (index < jobs.length && endTime >= jobs[index][0]) {
                pq.offer(jobs[index++]);
            }
            
            // pq가 비어있는경우 (대기하는 작업 X) endTime을 다음 요청의 시작시간에 맞춤
            if (pq.isEmpty()) {
                endTime = jobs[index][0];
            } else {
                int[] cur = pq.poll();
                
                // endTime보다 현재 작업의 시작 시간이 작은 경우 -> 대기시간있음.
                if (endTime > cur[0]) {
                    waiting = endTime - cur[0];
                }
                
                endTime += cur[1];
                total += waiting + cur[1];
                count++;
            }
        }
        
        return answer = (int) Math.floor(total / count);
    }
}
