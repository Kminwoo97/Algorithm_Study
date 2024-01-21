import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        if (N == number) {
            return answer = 1;
        } 
        
        for (int i = 2; i < 9; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(N).repeat(i));
            int value = Integer.parseInt(sb.toString());

            if (value == number) {
                answer = i;
                break;
            } else {
                dp.get(i).add(value);
            }
            
            boolean flag = false;
            
            for (int j = 1; j < i; j++) {
                Set<Integer> pre1 = dp.get(i - j);
                Set<Integer> pre2 = dp.get(j);
                
                for (int el1 : pre1) {
                    for (int el2 : pre2) {
                        int plus = el1 + el2;
                        int minus = el1 - el2; 
                        int multi = el1 * el2;
                        int divide = el1 / el2;

                        if (plus == number || minus == number || multi == number || divide == number) {
                            flag = true;
                            break;
                        }
                        
                        if (plus != 0) dp.get(i).add(plus);
                        if (minus != 0) dp.get(i).add(minus);
                        if (multi != 0) dp.get(i).add(multi);
                        if (divide != 0) dp.get(i).add(divide);
                    }
                    
                    if (flag) break;
                    
                }
                
                if (flag) break;
                
            }
            
            if (flag) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
