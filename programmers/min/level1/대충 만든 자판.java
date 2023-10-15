import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        //HashMap에 알파벳 순서 담기
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++){
            String key = keymap[i];
            
            for(int j=0; j<key.length(); j++){
                Character x = key.charAt(j);
                
                if(map.containsKey(x)){
                    int cur = map.get(x);
                    map.put(x, Math.min(cur , j + 1));
                }else{
                    map.put(x, j + 1);
                }
            }
        }
        
        //정답 도출
        for(int i=0; i<answer.length; i++){
            String target = targets[i];
            
            for(int j=0; j<target.length(); j++){
                Character x = target.charAt(j);
                
                if(map.containsKey(x)){
                    answer[i] += map.get(x);
                }else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
