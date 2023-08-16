import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        if(cacheSize == 0){
            answer += cities.length * 5;
        }else{
            for(int i=0; i<cities.length; i++){
                String city = cities[i].toUpperCase();
            
                if(q.contains(city)){
                    answer += 1;

                    q.remove(city);
                    q.offer(city);
                }else{
                    if(q.size() == cacheSize){
                        q.poll();
                        q.offer(city);
                    }else{
                        q.offer(city);
                    }

                    answer += 5;
                }

            }
        }
        
        return answer;
    }
}
