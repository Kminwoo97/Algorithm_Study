import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 1;
        int i = 0;
        int sum = truck_weights[i];
        Queue<Truck> queue = new LinkedList<>();
        
        queue.offer(new Truck(time, truck_weights[i++], bridge_length));
        
        while (!queue.isEmpty()) {
            time++;
            Truck truck = queue.peek();
            
            if (truck.end == time) {
                Truck p = queue.poll();
                sum -= p.weight;
            }
            
            if (i < truck_weights.length) {
                if (sum + truck_weights[i] <= weight) {
                    sum += truck_weights[i];
                    queue.offer(new Truck(time, truck_weights[i], bridge_length));
                    i++;
                }
            }
        }
        
        return answer = time;
    }
}

class Truck {
    int start; // 다리에 올라온 시간
    int weight; // 트럭 무게
    int end; // 다리에서 나가는 시간
    
    Truck (int start, int weight, int bridgeLength) {
        this.start = start;
        this.weight = weight;
        this.end = bridgeLength + start;
    }
}
