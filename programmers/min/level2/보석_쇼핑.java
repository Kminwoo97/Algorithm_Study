import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        int lt = 0;
        for(int rt=0; rt<gems.length; rt++){
            map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);
            while(map.size() == set.size()){
                if(answer[1] - answer[0] > rt - lt){
                    answer[0] = lt + 1;
                    answer[1] = rt + 1;
                }
                
                if(map.get(gems[lt]) == 1)
                    map.remove(gems[lt]);
                else
                    map.put(gems[lt], map.get(gems[lt])-1);
                
                lt++;
            }
        }
        
        return answer;
    }
}
