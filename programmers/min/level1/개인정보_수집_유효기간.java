import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        
        //보관기간 HashMap에 저장
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++){
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        //오늘 날짜를 숫자로 표기
        String[] split_today = today.split("\\.");
        int today_number = 12 * 28 * Integer.parseInt(split_today[0])
                    + 28 * Integer.parseInt(split_today[1])
                    + Integer.parseInt(split_today[2]);
        
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            String[] before_day = privacy[0].split("\\.");
            
            //만료날짜 계산 
            int expire_number = 12 * 28 * Integer.parseInt(before_day[0])
                            + 28 * Integer.parseInt(before_day[1])
                            + Integer.parseInt(before_day[2])
                            + 28 * map.get(privacy[1]);
            
            //오늘과 만료날짜비교
            if(today_number >= expire_number)
                list.add(i+1);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
