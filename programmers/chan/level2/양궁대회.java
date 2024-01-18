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
        if (count == n) {
            if (max <= lionScore - apeachScore) {
                max = lionScore - apeachScore;
                ans = list;
            }
            
            return;
        }
        
        for (int i = start; i < 11; i++) {
            // 1. 해당 점수에 화살 쏘는 경우
            // 어피치가 i 점에 맞춘 화살 있는 경우
            if (info[i] != 0) {
                // 어피치가 쏜 화살보다 한 발 많은 수 = 라이언이 점수 획득 가능한 경우
                if (count + info[i] + 1 <= n) {
                    // System.out.println(count + info[i] + 1);
                    List<int[]> sub = new ArrayList<>(list);
                    sub.add(new int[]{i, info[i] + 1});
                    dfs(info, n, count + info[i] + 1, start + 1, apeachScore, lionScore + (10 - i), sub);
                } else {
                    dfs(info, n, count, start + 1, apeachScore + (10 - i), lionScore, list);
                }
            } else {
                
            }
        }
    }
}
