import java.util.*;

class Solution {
    public static List<String> list = new ArrayList<>();
        
    public static long solution(String expression) {
        long answer = 0;
        
        String[] nums = expression.split("[^0-9]+");
        String[] opers = expression.split("\\d+");
        
        Set<String> set = new HashSet<>();
        
        for (int i = 1; i < opers.length; i++) {
            set.add(opers[i]);
        }
        
        String[] op = new String[set.size()];
        int index = 0;
        
        for (String key : set) {
            op[index++] = key;
        }
        
        // 연산자 조합 정하기
        dfs(op, new StringBuilder(), new boolean[set.size()]);

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            Map<Character, Integer> frequency = new HashMap<>();
            
            // 우선순위 저장
            for (int j = 0; j < str.length(); j++) {
                frequency.put(str.charAt(j), j);
            }
            
            // 리스트 초기화
            List<Long> operands = new ArrayList<>();
            List<Character> operators = new ArrayList<>();
            
            for (int j = 0; j < nums.length; j++) {
                operands.add(Long.parseLong(nums[j]));
            }
            
            for (int j = 1; j < opers.length; j++) {
                operators.add(opers[j].charAt(0));
            }
            
            int first = 0;
            int idx = 0;
            
            while (operators.size() > 0) {
                char oper = operators.get(idx);
                
                // 우선순위 가장 높은 경우
                if (frequency.get(oper) == first) {
                    long operand1 = operands.get(idx);
                    long operand2 = operands.get(idx + 1);
                    long sum = calc(oper, operand1, operand2);
                    
                    operands.add(idx, sum);
                    operands.remove(idx + 1);
                    operands.remove(idx + 1);
                    operators.remove(idx);
                } else {
                    idx++;
                }
                
                if (idx == operators.size()) {
                    idx = 0;
                    first++;
                }
            }
            
            answer = Math.max(answer, Math.abs(operands.get(0)));
        }
        
        return answer;
    }
    
    public static void dfs(String[] op, StringBuilder sb, boolean[] isVisited) {
        if (sb.length() == op.length) {
            list.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < op.length; i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                StringBuilder sub = new StringBuilder(sb);
                sub.append(op[i]);
                
                dfs(op, sub, isVisited);
                isVisited[i] = false;
            }
        }
    }
    
    public static long calc(char operator, long operand1, long operand2) {
        long result = 0;
        
        if (operator == '+') {
            result = operand1 + operand2;
        } else if (operator == '-') {
            result = operand1 - operand2;
        } else {
            result = operand1 * operand2;
        }
        
        return result;
    }
}
