import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int t = 0;
        int sum = 0;
        Queue<int[]> q = new LinkedList<>(); // 트럭무게, 현재시간
        
        for (int i = 0; i < truck_weights.length; i++) {
            if (!q.isEmpty()) {
                // 다리 위에 추가로 올라갈 수 없는 경우
                while (sum + truck_weights[i] > weight) {
                    int[] pre = q.poll();
                    sum -= pre[0];
                    
                    // 아직 트럭이 빠져나오지 못한 경우
                    if (t < pre[1] + bridge_length) {
                        t = pre[1] + bridge_length;
                    }
                }
            }
            
            sum += truck_weights[i];
            q.add(new int[]{truck_weights[i], t});
            t++;
        }
        
        while (!q.isEmpty()) {
            answer = q.poll()[1] + bridge_length + 1;
        }
        
        return answer;
    }
}
