
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        //투포인터 접근법
        int lt = 0;
        int rt = -1;
        long sum = 0;
        long total = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int x : queue1){
            list.add(x);
            total += x;
            sum += x;
            rt++;
        }
        for(int x : queue2){
            list.add(x);
            total += x;
        }
        
        long target = total / 2;
        while(sum != target){
            
            if(sum > target){
                sum -= list.get(lt);
                lt = (lt + 1) % list.size();
            }else if(sum < target){
                rt = (rt + 1) % list.size();
                sum += list.get(rt);
            }
            
            answer += 1;
            
            //합이 0이 되는 순간은 lt 와 rt가 교차되는 순간이다.
            if(sum <= 0){
                return -1;
            }
            
            //무한루프 도는 경우
            if(answer > list.size() * 2){
                return -1;
            }
        }
        
        return answer;
    }
}
