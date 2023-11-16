import java.util.*;

class Solution {
    public static List<String> list = new ArrayList<>();
        
    public static long solution(String expression) {
        long answer = 0;
        Set<Character> set = new HashSet<>();
        
        String[] nums = expression.split("[^0-9]+");
        String[] opers = expression.split("\\d+");
        String[] exp = new String[nums.length + opers.length - 1];
        int numIdx = 0;
        int operIdx = 1;
        int expIdx = 0;
        
        while (expIdx < exp.length) {
            if (expIdx % 2 == 0) {
                exp[expIdx] = nums[numIdx++];
            } else {
                exp[expIdx] = opers[operIdx++];
            }
            
            expIdx++;
        }
        
        Map<String, Integer> cnt = new HashMap<>();
        
        for (int i = 1; i < opers.length; i++) {
            cnt.put(opers[i], cnt.getOrDefault(opers[i], 0) + 1);
        }
        
        List<String> keys = new ArrayList<>(cnt.keySet());
        String[] op = new String[keys.size()];
        int index = 0;
        
        for (String key : keys) {
            op[index++] = key;
        }
        
        // 연산자 조합 정하기
        dfs(op, new StringBuilder(), new boolean[keys.size()]);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            Map<Character, Integer> precedenceMap = new HashMap<>(); // 연산자, 우선순위
            Map<Integer, Integer> frequencyMap = new HashMap<>(); // 우선순위, 빈도
            
            Stack<Long> operand = new Stack<>();
            Stack<Character> operator = new Stack<>();
            
            for (int j = 0; j < str.length(); j++) {
                precedenceMap.put(str.charAt(j), j);
                frequencyMap.put(j, cnt.get(str.charAt(j)));
            }
            
            for (int j = 0; j < exp.length; j++) {
                if (j % 2 == 0) {
                    operand.push(Long.parseLong(exp[i]));
                    
                    boolean isFirst = true;
                    
                    while (!operator.isEmpty() && isFirst) {
                        char peek = operator.peek();
                        int value = precedenceMap.get(peek);

                        // 우선순위 더 높은 연산자 남았는지 확인
                        for (int k = 0; k < value; k++) {
                            if (frequencyMap.get(k) > 0) {
                                isFirst = false;
                                break;
                            }
                        }

                        if (isFirst) {
                            long pop1 = operand.pop();
                            long pop2 = operand.pop();

                            long sum = calc(operator.pop(), pop2, pop1);
                            operand.push(sum);
                        }
                    }
                } else {
                    operator.push(exp[i].charAt(0));
                }
            }
            
            answer = Math.max(answer, operand.pop());
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
