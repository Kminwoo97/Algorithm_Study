import java.util.*;


class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        //대문자로 치환
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        //str1, str2 각각에 대해 다중집합 만들기
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<str1.length() - 1; i++){
            String key = str1.substring(i, i+2).replaceAll("[^A-Z]", "");
            if(key.length() == 2){
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }
        for(int i=0; i<str2.length() - 1; i++){
            String key = str2.substring(i, i+2).replaceAll("[^A-Z]", "");
            if(key.length() == 2){
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }
        }
        
        double hap = 0;
        double gyo = 0;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                hap += Math.max(map1.get(key), map2.get(key));
                gyo += Math.min(map1.get(key), map2.get(key));
                
                map2.put(key,0);
            }else{
                hap += map1.get(key);
            }
        }
        
        //남은 것들 더하기
        for(String key : map2.keySet())
            hap += map2.get(key);
        
        
        if(map1.isEmpty() && map2.isEmpty())
            answer = 65536;
        else
            answer = (int)((gyo / hap) * 65536);
    
        
        return answer;
    }
    
    public double Jkad(ArrayList<String> str1, ArrayList<String> str2){
        
        return 1.0;
    }
}
