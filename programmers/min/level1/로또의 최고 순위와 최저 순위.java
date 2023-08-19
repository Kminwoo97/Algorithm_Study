import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        //로또번호 맞춘 것과 지워진 번호 카운팅
        int cnt = 0;
        int zeroCnt = 0;
        for(int lotto : lottos){
            
            if(lotto == 0){
                zeroCnt++;
                continue;
            }
            
            for(int win : win_nums){
                if(lotto == win){
                    cnt++;
                }
            }
        }
        
        answer[0] = getRank(cnt+zeroCnt);
        answer[1] = getRank(cnt);
        
        return answer;
    }
    
    public int getRank(int num){
        if(num <= 1)
            return 6;
        return 6 - num + 1; 
    }
}
