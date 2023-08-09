import java.util.*;

public class 짝지어_제거하기 {
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                char p = stack.pop();

                if (s.charAt(i) != p) {
                    stack.push(p);
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}
