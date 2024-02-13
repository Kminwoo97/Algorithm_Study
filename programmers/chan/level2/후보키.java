import java.util.*;

class Solution {
    static List<Set<Integer>> ans = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        for (int i = 0; i < relation[0].length; i++) {
            // i + 1 개를 조합해서 만들 수 있는 키의 조합 구하기
            dfs(relation, new HashSet<>(), 0, i + 1, 0);
        }
        
        return answer = ans.size();
    }
    
    public void dfs(String[][] relation, Set<Integer> set, int start, int count, int depth) {
        
        if (count == depth) {
            // 유일성 검사
            List<String> list = new ArrayList<>();
            
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                for (int el : set) {
                    sb.append(relation[i][el]);
                }
                
                if (list.contains(sb.toString())) {
                    return;
                }
                
                list.add(sb.toString());
            }
            
            // 최소성 검사
            for (Set st : ans) {
                if (set.containsAll(st)) {
                    return;
                }
            }
            
            ans.add(set);
        }
        
        for (int i = start; i < relation[0].length; i++) {
            Set<Integer> sub = new HashSet<>(set);
            sub.add(i);
            
            dfs(relation, sub, i + 1, count, depth + 1);
        }
    }
}
