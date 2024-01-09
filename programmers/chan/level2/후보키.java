import java.util.*;

class Solution {
    static List<Set<Integer>> list = new ArrayList<>();
    static int result = 0;
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        for (int i = 0; i < relation[0].length; i++) {
            dfs(relation, new HashSet<>(), i + 1, 0, 0);
        }
        
        return answer = result;
    }
    
    public void dfs(String[][] relation, Set<Integer> set, int count, int depth, int start) {
        if (depth == count) {
            // 유일성 검사
            List<String> keys = new ArrayList<>();
            
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                for (int el : set) {
                    sb.append(relation[i][el]);
                }
                
                if (!keys.contains(sb.toString())) {
                    keys.add(sb.toString());
                } else {
                    return;
                }
            }
            
            // 최소성 검사
            for (Set<Integer> key : list) {
                if (set.containsAll(key)) {
                    return;
                }
            }
            
            list.add(set);
            result++;
            
            return;
        }
        
        for (int i = start; i < relation[0].length; i++) {
            Set<Integer> sub = new HashSet<>(set);
            sub.add(i);
            
            dfs(relation, sub, count, depth + 1, i + 1);
        }
    }
}
