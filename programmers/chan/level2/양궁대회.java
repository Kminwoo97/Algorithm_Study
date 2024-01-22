import java.util.*;

class Solution {
    static int max = 0;
    static List<int[]> ans = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        dfs(info, n, 0, 0, 0, 0, new ArrayList<>());
        
        // 라이언이 못 이기는 경우
        if (ans.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[11];
        
            for (int i = 0; i < ans.size(); i++) {
                int idx = ans.get(i)[0];
                int value = ans.get(i)[1];

                answer[idx] = value;
            }
        }
        
        
        return answer;
    }
    
    public void dfs(int[] info, int n, int count, int start, int apeachScore, int lionScore, List<int[]> list) {
        if (start == 11) {
            return;
        }
        
        if (count == n) {
            if (max <= lionScore - apeachScore) {
                max = lionScore - apeachScore;
                ans = list;
            }
            
            return;
        }
        
        // 1. 해당 점수에 화살 쏘는 경우
        if (count + info[start] + 1 <= n) {
            List<int[]> sub = new ArrayList<>(list);
            sub.add(new int[]{start, info[start] + 1});
            dfs(info, n, count + info[start] + 1, start + 1, apeachScore, lionScore + 10 - start, sub);
        }

        // 2. 해당 점수에 쏘지 않는 경우
        dfs(info, n, count, start + 1, apeachScore + 10 - start, lionScore, list);
    }
}
