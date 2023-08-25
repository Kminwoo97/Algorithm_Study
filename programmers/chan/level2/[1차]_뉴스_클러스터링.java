import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>(); // str1의 다중집합의 원소별 갯수 카운트
        Map<String, Integer> map2 = new HashMap<>(); // str2의 다중집합의 원소별 갯수 카운트
        List<String> keys1 = new ArrayList<>();
        List<String> keys2 = new ArrayList<>();
        List<String> list1 = getMultiset(str1, map1, keys1);
        List<String> list2 = getMultiset(str2, map2, keys2);
        
        
        double union = 0;
        double intersection = 0;
        double quot = 0;
        
        union = getUnion(keys1, keys2, map1, map2);
        intersection = getIntersection(keys1, map1, map2);
        
        if (union == 0) {
            quot = 1;
        } else {
            quot = intersection / union;
        }
        
        quot *= 65536;
        
        return answer = (int) quot;
    }
    
    public List<String> getMultiset(String str, Map<String, Integer> map, List<String> keys) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            
            if (i != 0 && i != str.length() - 1) {
                sb.append(str.charAt(i));
            }
        }
        
        for (int i = 0; i < sb.length(); i = i + 2) {
            if (sb.charAt(i) >= 97 && sb.charAt(i) <= 122 && 
                sb.charAt(i + 1) >= 97 && sb.charAt(i + 1) <= 122) {
                
                String sub = sb.charAt(i) + "" + sb.charAt(i + 1);
                list.add(sub);
                int value = map.getOrDefault(sub, 0);
                map.put(sub, value + 1);
                
                if (value == 0) {
                    keys.add(sub);
                }
            }
        }
        
        return list;
    }
    
    public double getUnion(List<String> keys1, List<String> keys2, Map<String, Integer> map1, Map<String, Integer> map2) {
        List<String> unionList = new ArrayList<>();
        
        for (int i = 0; i < map1.size(); i++) {
            int value1 = map1.get(keys1.get(i));
            int value2 = map2.getOrDefault(keys1.get(i), 0);
            
            int frequency = Math.max(value1, value2);
            
            for (int j = 0; j < frequency; j++) {
                unionList.add(keys1.get(i));
            }
        }
                    
        for (int i = 0; i < map2.size(); i++) {
            int value1 = map2.get(keys2.get(i));
            int value2 = map1.getOrDefault(keys2.get(i), 0);
            
            if (value2 == 0) {
                for (int j = 0; j < value1; j++) {
                    unionList.add(keys2.get(i));
                }
            }
        }
        
        return unionList.size();
    }
    
    public double getIntersection(List<String> keys, Map<String, Integer> map1, Map<String, Integer> map2) {
        List<String> intersectionList = new ArrayList<>();
        
        for (int i = 0; i < map1.size(); i++) {
            int value1 = map1.get(keys.get(i));
            int value2 = map2.getOrDefault(keys.get(i), 0);
            
            if (value2 != 0) {
                int frequency = Math.min(value1, value2);
            
                for (int j = 0; j < frequency; j++) {
                    intersectionList.add(keys.get(i));
                }
            }
        }
        
        return intersectionList.size();
    }
}
