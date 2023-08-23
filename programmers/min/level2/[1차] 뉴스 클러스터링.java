import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        //입력값 소문자로
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        //다중집합 만들기
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for(int i=0; i<str1.length()-1; i++){
            String key = str1.substring(i,i+2).replaceAll("[^a-z]","");
            if(key.length() != 2)
                continue;
            mapA.put(key, mapA.getOrDefault(key, 0) + 1);
        }
        for(int i=0; i<str2.length()-1; i++){
            String key = str2.substring(i,i+2).replaceAll("[^a-z]","");
            if(key.length() != 2)
                continue;
            mapB.put(key, mapB.getOrDefault(key, 0) + 1);
        }
        
        //교집합, 합집합 구하기
        int intersect = 0;
        int union = 0;
        for(String key : mapA.keySet()){
            if(mapB.containsKey(key)){
                intersect += Math.min(mapA.get(key), mapB.get(key));
                union += Math.max(mapA.get(key), mapB.get(key));
                
                mapB.remove(key);
            }else{
                union += mapA.get(key);
            }
        }
        
        for(String key : mapB.keySet()){
            union += mapB.get(key);
        }
        
        //정답 도출
        if(intersect == 0 && union == 0)
            answer = 65536;
        else{
            answer = (int)((intersect / (double)union) * 65536);
        }
        
        return answer;
    }
}
