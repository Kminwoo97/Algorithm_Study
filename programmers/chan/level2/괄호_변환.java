import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = recursive(p);
        
        return answer;
    }
    
    public String recursive(String w) {
        if (w.equals("")) {
            return w;
        } else {
            // w를 u, v로 반환. u를 균형잡힌 괄호 문자열로 더이상 분리할 수 없어야 (최소단위)
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            int leftCnt = 0;
            int rightCnt = 0;
            String u = "";
            String v = "";
            
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) == '(') {
                    leftCnt++;
                    stack.push('(');
                } else {
                    rightCnt++;
                    
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isBalanced = false;
                    }
                }
                
                if (leftCnt == rightCnt) {
                    u = w.substring(0, i + 1);
                    v = w.substring(i + 1);
                    break;
                }
            }
            
            // u가 올바른 괄호 문자열이라면 문자열 v에 대해 1단계부터 수행
            if (isBalanced && stack.isEmpty()) {
                u += recursive(v);
                
                return u;
            } else {
            // 아니라면, 새 과정 수행. 
                StringBuilder blank = new StringBuilder();
                blank.append("(");
                blank.append(recursive(v));
                blank.append(")");
                
                for (int j = 1; j < u.length() - 1; j++) {
                    if (u.charAt(j) == '(') {
                        blank.append(")");
                    } else {
                        blank.append("(");
                    }
                }
                
                return blank.toString();
            }
        }
    }
}
