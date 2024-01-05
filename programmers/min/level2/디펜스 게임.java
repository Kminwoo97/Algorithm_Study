import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        
        int answer = 0;
        
        //최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            pq.offer(enemy[i]);
            
            if(n < 0){
                if(k > 0){
                    n += pq.poll();
                    k--;
                }else{
                    return i;
                }
            }
        }
        
        answer = enemy.length;
        
        return answer;
    }
    
}
