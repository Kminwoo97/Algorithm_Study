import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        //사전 초기화
        Map<String, Integer> word = new HashMap<>();
        char alpha = 'A';
        int idx = 26;
        for(int i=0; i<26; i++){
            word.put(Character.toString(alpha+i),i+1);
        }
        
        
        ArrayList<Integer> list = new ArrayList<>();
        int start, end;
        start = end = 0;
        while(end < msg.length()){
            String sub = msg.substring(start, end + 1);
            if(word.containsKey(sub)){
                end++;
            }
            else{
                list.add(word.get(msg.substring(start, end)));
                word.put(sub, ++idx);
                start = end;
            }
        }
        list.add(word.get(msg.substring(start,end)));
        
        //정답 도출
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
