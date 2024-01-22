import java.util.*;

class Solution {
    static int max = 1;
    static List<int[]> ans = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        
        dfs(info, n, 0, 0, 0, 0, new ArrayList<>());
        
        for (int i = 0; i < ans.size(); i++) {
            int[] value = ans.get(i);
            answer[value[0]] = value[1];
        }
        
        // 라이언 못 이기는 경우
        if (ans.size() == 0) {
            answer = new int[]{-1};
        }
        
        return answer;
    }
    
    public void dfs(int[] info, int n, int count, int start, int apeachScore, int lionScore, List<int[]> list) {
        
        if (start == 11) {
            int diff = lionScore - apeachScore;
            
            if (count < n) {
                list.add(new int[]{10, n - count});
                count = n;
            }
            
            if (max < diff) {
                max = diff;
                ans = list;
                
                return;
            } 
            
            if (max == diff) {
                max = diff;
                
                if (ans.size() == 0) {
                    ans = list;
                } else {
                    int[] value1 = ans.get(ans.size() - 1);
                    int[] value2 = list.get(list.size() - 1);
                    
                    if (value1[0] < value2[0]) {
                        ans = list;
                    } else if (value1[0] == value2[0]) {
                        if (value1[1] < value2[1]) {
                            ans = list;
                        }
                    }
                }
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
        // 2-1. 어피치 점수 획득한 경우 
        if (info[start] > 0) {
            dfs(info, n, count, start + 1, apeachScore + 10 - start, lionScore, list);
        } else {
            dfs(info, n, count, start + 1, apeachScore, lionScore, list);
        }
    }
}
