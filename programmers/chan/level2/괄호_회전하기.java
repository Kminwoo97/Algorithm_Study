import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();        
        sb.append(s);
        
        if (s.length() % 2 != 0) {
            return 0;
        }
        
        for (int i = 0; i < s.length(); i++) {
            sb.insert(sb.length(), sb.charAt(0));
            sb.delete(0, 1);
            
            int count = 0;
            
            for (int j = 0; j < s.length(); j++) {
                char ch = sb.charAt(j);

                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty()) {
                        char p = stack.pop();

                        switch (ch) {
                                case ')':
                                if (p == '(') count++;
                                break;
                                case ']':
                                if (p == '[') count++;
                                break;
                                case '}':
                                if (p == '{') count++;
                                break;
                        }
                    } else {
                        break;
                    }
                }
            }
            
            if (count == s.length() / 2) {
                answer++;
            }
        }
        
        
        return answer;
    }
}
