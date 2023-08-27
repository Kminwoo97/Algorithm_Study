import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Queue<Integer> bridge = new LinkedList<>(); //다리를 지나는 트럭
        Queue<Integer> waiting_truck = new LinkedList<>(); //대기중인 트럭

        //대기중인 트럭 , 다리 상태 초기화
        for(int truck : truck_weights)
            waiting_truck.offer(truck);
        for(int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }
        
        int cur_weight = 0;
        while(!bridge.isEmpty()){
            time++;
            cur_weight -= bridge.poll();
            
            if(!waiting_truck.isEmpty()){
                if(cur_weight + waiting_truck.peek() <= weight){
                    cur_weight += waiting_truck.peek();
                    bridge.offer(waiting_truck.poll());
                }else{
                    bridge.offer(0);
                }
            }
        }
        
        return time;
    }
}
