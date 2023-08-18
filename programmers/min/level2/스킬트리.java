import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            String x = skill_trees[i].replaceAll("[^"+skill+"]", "");
            boolean flag = false;
            
            for(int j=1; j<=skill.length(); j++){
                String sub = skill.substring(0, j);
                if(x.equals(sub) || x.equals("")){
                    flag = true;
                    break;
                }
            }
            
            if(flag)
                answer++;
            
        }
        
        
        return answer;
    }
}
