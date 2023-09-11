import java.util.*;

class Solution {
    static Set<Set<String>> ans = new HashSet<>();
    static boolean[] isVisited;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        isVisited = new boolean[user_id.length];
        
        dfs(user_id, banned_id, new LinkedHashSet<>(), isVisited);
        
        return answer = ans.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, Set<String> set, boolean[] isVisited) {
        
        if (set.size() == banned_id.length) {
            // set과 banned_id 요소 비교
            boolean isMatched = true;
            int i = 0;
            int count = 0;
            
            for (String userId : set) {
                String bannedId = banned_id[i++].replaceAll("\\*", ".");
                
                if (userId.length() == bannedId.length() && userId.matches(bannedId)) {
                    count++;
                }
            }
            
            if (count == banned_id.length) {
                ans.add(set);
            }
            
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                Set<String> sub = new LinkedHashSet<>(set);
                
                sub.add(user_id[i]);
                dfs(user_id, banned_id, sub, isVisited);
                isVisited[i] = false;
            }
        }
    }
}
