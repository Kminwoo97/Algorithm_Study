import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    public int solution(String dartResult) {
        int answer = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char curChar = dartResult.charAt(i);

            if (curChar >= 48 && curChar < 58) {
                int score = (int) (curChar - 48);

                if (dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++;
                }

                switch (dartResult.charAt(i + 1)) {
                    case 'D':
                        score = (int) Math.pow(score, 2);
                        break;
                    case 'T':
                        score = (int) Math.pow(score, 3);
                        break;
                }

                stack.push(score);
            } else {
                switch (curChar) {
                    case '*':
                        if (stack.size() > 1) {
                            int cur = stack.pop();
                            int pre = stack.pop();
                            cur *= 2;
                            pre *= 2;

                            stack.push(pre);
                            stack.push(cur);
                        } else {
                            int cur = stack.pop();
                            cur *= 2;

                            stack.push(cur);
                        }

                        break;
                    case '#':
                        int cur = stack.pop();
                        cur *= -1;

                        stack.push(cur);

                        break;
                }
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}