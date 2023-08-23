import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        //논문의 인용횟수 = citations[i]
        //해당 논문보다 인용횟수가 크거나 같은 논문 수 = h
        for(int i=0; i<citations.length; i++){
            if(citations[i] >= citations.length - i){
                answer = citations.length - i;
                break;
            }
        }
        
        
        return answer;
    }
}
