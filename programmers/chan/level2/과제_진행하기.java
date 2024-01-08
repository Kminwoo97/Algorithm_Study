import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<String> ans = new ArrayList<>();
        Stack<Assignment> stack = new Stack<>();
        
        Arrays.sort(plans, (e1, e2) -> e1[1].compareTo(e2[1]));
        
        for (int i = 0; i < plans.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Assignment(plans[i][0], 
                                          convertToInt(plans[i][1]), 
                                          Integer.parseInt(plans[i][2])));
            } else {
                Assignment pre = stack.pop();
                int timediff = convertToInt(plans[i][1]) - pre.start;
                
                // 이전 작업 끝과 동시에 새 작업 시작하는 경우
                if (timediff == pre.playTime) {
                    ans.add(pre.name);
                } else if (timediff < pre.playTime) {
                    // 이전 작업이 끝나기 전에 새 작업 시작하는 경우
                    pre.playTime -= timediff;
                    stack.push(pre);
                } else {
                    // 이전 작업 끝난 후 새 작업 시작하는 경우
                    ans.add(pre.name);
                    int remainTime = timediff - pre.playTime;
                    
                    while (remainTime > 0) {
                        // 남은 시간동안 스택에 있는 작업 처리
                        if (!stack.isEmpty()) {
                            Assignment pre2 = stack.pop();
                            
                            int timediff2 = pre2.playTime - remainTime;
                            
                            // 남은 작업 처리 다 못하는 경우
                            if (timediff2 > 0) {
                                pre2.playTime -= remainTime;
                                stack.push(pre2);
                                remainTime = 0;
                            } else {
                                remainTime -= pre2.playTime;
                            }
                        }
                    }
                }
                
                stack.push(new Assignment(plans[i][0], 
                                          convertToInt(plans[i][1]), 
                                          Integer.parseInt(plans[i][2])));
            }
        }
        
        while (!stack.isEmpty()) {
            ans.add(stack.pop().name);
        }
        
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    public int convertToInt(String time) {
        String[] times = time.split(":");
        
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}


class Assignment {
    String name;
    int start;
    int playTime;
    
    public Assignment (String name, int start, int playTime) {
        this.name = name;
        this.start = start;
        this.playTime = playTime;
    }
}
