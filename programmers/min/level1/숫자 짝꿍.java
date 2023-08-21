import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        //1. 카운팅
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for(String key : X.split("")){
            mapA.put(key, mapA.getOrDefault(key, 0) + 1);
        }
        for(String key : Y.split("")){
            mapB.put(key, mapB.getOrDefault(key, 0) + 1);
        }
        
        //2. 겹치는 거 카운팅
        ArrayList<Integer> list = new ArrayList<>();
        for(String key : mapA.keySet()){
            int a = mapA.get(key);
            int b = mapB.getOrDefault(key, 0);
            if(b != 0){
                for(int i=0; i<Math.min(a,b); i++){
                    list.add(Integer.parseInt(key));
                }
            }
        }
        
        //3. 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        //4. 정답도출
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        
        if(sb.toString().equals("")){
            answer = "-1";
        }else{
            answer = sb.toString();
            if(answer.length() >=2 && answer.substring(0,2).equals("00"))
                answer = "0";
        }
        
        return answer;
    }
}
