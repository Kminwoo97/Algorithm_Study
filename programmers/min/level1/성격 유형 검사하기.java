import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        
            
        for(int i=0; i<survey.length; i++){
            String[] type = survey[i].split("");
            int sel_num = choices[i];
            
            //매우 비동의, 비동의, 약간 비동의, ??, 약간 동의, 동의, 매우 동의(1 ~ 7)
            switch(sel_num){
                case 1:
                    map.put(type[0], map.getOrDefault(type[0], 0) + 3);
                    break;
                case 2:
                    map.put(type[0], map.getOrDefault(type[0], 0) + 2);
                    break;
                case 3:
                    map.put(type[0], map.getOrDefault(type[0], 0) + 1);
                    break;
                case 4:
                    map.put(type[0], map.getOrDefault(type[0], 0) + 0);
                    map.put(type[1], map.getOrDefault(type[1], 0) + 0);
                    break;
                case 5:
                    map.put(type[1], map.getOrDefault(type[1], 0) + 1);
                    break;
                case 6:
                    map.put(type[1], map.getOrDefault(type[1], 0) + 2);
                    break;
                case 7:
                    map.put(type[1], map.getOrDefault(type[1], 0) + 3);
                    break;
            }
        }
        
        //성격 유형 판단하기
        int a = map.get("R");
        int b = map.get("T");
        answer += decision(a, b, "R", "T");
        
        a = map.get("C");
        b = map.get("F");
        answer += decision(a, b, "C", "F");
        
        a = map.get("J");
        b = map.get("M");
        answer += decision(a, b, "J", "M");
        
        a = map.get("A");
        b = map.get("N");
        answer += decision(a, b, "A", "N");
        
        return answer;
    }
    
    public String decision(int a, int b, String x, String y){
        if(a > b || a == b)
            return x;
        
        return y;
    }
}
