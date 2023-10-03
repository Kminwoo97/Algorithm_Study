import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        List<String> list = Arrays.stream(numbers)
            .mapToObj(Integer::toString)
            .collect(Collectors.toList());
        
        Collections.sort(list, (e1, e2) -> {
            String str1 = e1 + e2;
            String str2 = e2 + e1;
            
            return Integer.parseInt(str2) - Integer.parseInt(str1);
        });
        
        if (list.get(0).equals("0")) {
            return "0";
        } 
        
        for (String el : list) {
            sb.append(el);
        }
        
        return answer = sb.toString();
    }
}
