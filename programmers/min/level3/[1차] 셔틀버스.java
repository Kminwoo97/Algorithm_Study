import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        //크루들이 오는 시간을 우선순위 큐에 넣는다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable){
            int hour = Integer.parseInt(time.split(":")[0]);
            int min = Integer.parseInt(time.split(":")[1]);
            pq.offer(hour * 60 + min);
        }
        
        
        //콘은 마지막 버스에 타야한다.
        //만약 마지막 버스에 자리가 없다면 마지막 크루보다 1분 빨리오면 된다.
        int busCount = 1;
        int arrivedBusTime = 9 * 60;
        while(busCount <= n){
            if(busCount != 1)
                arrivedBusTime += t;
            
            int busPersonCnt = 0;
            while(pq.size() != 0 && busPersonCnt <= m-1){
                
                //크루가 버스시간보다 늦게오면 break(다음 버스에 타야한다)
                if(pq.peek() > arrivedBusTime)
                    break;
                
                //마지막 버스이고 버스의 자리가 한자리만 남았다면 마지막 사람보다 1분 빨리와야한다.
                if(busCount == n && busPersonCnt == m - 1){
                    int conArrived = pq.peek() - 1;
                    int hour = conArrived / 60;
                    int min = conArrived % 60;
                    return String.format("%02d:%02d", hour, min);
                }
                
                pq.poll();
                busPersonCnt++;
            }
            busCount++;
        }
        
        int hour = arrivedBusTime / 60;
        int min = arrivedBusTime % 60;
        answer = String.format("%02d:%02d", hour, min);
        
        return answer;
    }
}
