
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        //Map 에 UserId에 해당하는 NickName 기록
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<record.length; i++){
            String[] input = record[i].split(" ");
            
            if(input[0].equals("Enter")){
                map.put(input[1], input[2]);
                list.add("Enter " + input[1]);
            }else if(input[0].equals("Leave")){
                list.add("Leave " + input[1]);
            }else{
                map.put(input[1], input[2]);
            }
        }
        
        //정답도출
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            String[] rec = list.get(i).split(" ");
            if(rec[0].equals("Enter")){
                answer[i] = map.get(rec[1]) + "님이 들어왔습니다.";
            }else{
                answer[i] = map.get(rec[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
