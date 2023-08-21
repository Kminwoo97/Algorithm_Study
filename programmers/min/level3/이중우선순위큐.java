import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //최소힙, 최대힙 생성
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); 
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++){
            String op = operations[i].split(" ")[0];
            int x = Integer.parseInt(operations[i].split(" ")[1]);
            
            if(op.equals("I")){
                minPq.offer(x);
                maxPq.offer(x);
            }else{
                if(x == 1){
                    minPq.remove(maxPq.poll());
                }else{
                    maxPq.remove(minPq.poll());
                }
            }
        }
        
        if(maxPq.size() >= 2){
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }else if(maxPq.size() == 1){
            answer[0] = maxPq.poll();
            answer[1] = 0;
        }else{
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}
