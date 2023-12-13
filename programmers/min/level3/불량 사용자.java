import java.util.*;

class Solution {
    
    ArrayList<ArrayList<String>> list = new ArrayList<>();
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        ArrayList<ArrayList<String>> answer_list = new ArrayList<>();
        
        //1. 순열 구하기
        visited = new boolean[user_id.length];
        dfs(user_id, banned_id.length, new ArrayList<>());
        
        
        //2. 비교
        for(int i=0; i<list.size(); i++){
            
            boolean flag = true;
            ArrayList<String> t_list = list.get(i);
            
            for(int j=0; j<banned_id.length; j++){
                String ban = banned_id[j];
                String compare = t_list.get(j);
                
                if(ban.length() != compare.length()){
                    flag = false;
                    break;
                }
                
                for(int k=0; k<ban.length(); k++){
                    if(ban.charAt(k) != '*' && ban.charAt(k) != compare.charAt(k)){
                        flag = false;
                        break;
                    }
                }
                
                if(!flag)
                    break;
            }
            
            if(flag){
                answer_list.add(t_list);
            }
        }
        
        //3. 중복 제거
        for(int i=0; i<answer_list.size(); i++){
            Collections.sort(answer_list.get(i));
        }
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0; i<answer_list.size(); i++){
            set.add(answer_list.get(i));
        }
        
        answer = set.size();
        
        return answer;
    }
    
    public void dfs(String[] user_id, int max_cnt, ArrayList<String> str_list){
        if(max_cnt == str_list.size()){
            list.add((ArrayList<String>)str_list.clone());
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!visited[i]){
                visited[i] = true;
                str_list.add(user_id[i]);
                
                dfs(user_id, max_cnt, str_list);
                
                str_list.remove(String.valueOf(user_id[i]));
                visited[i] = false;
            }
        }
    }
}
