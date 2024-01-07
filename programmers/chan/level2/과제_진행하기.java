import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<String> ans = new ArrayList<>();
        Stack<Assignment> stack = new Stack<>();
        
        Arrays.sort(plans, (e1, e2) -> e1[1].compareTo(e2[1]));
        
        for (int i = 0; i < plans.length; i++) {
            if (!stack.isEmpty()) {
                Assignment pre = stack.pop();
                
                int remain = pre.start + pre.playTime - convertToInt(plans[i][1]);
                
                if (remain > 0) {
                    pre.start = convertToInt(plans[i][1]) + Integer.parseInt(plans[i][2]);
                    pre.playTime = remain;
                    stack.push(pre);
                } else if (remain < 0) {
                    ans.add(pre.name);
                    int remain2 = -remain;
                    
                    while (remain2 > 0) {
                        stack.pop();
                        
                        if (!stack.isEmpty()) {
                            Assignment pre2 = stack.pop();
                            
                            if (remain2 >= pre2.playTime) {
                                remain2 -= pre2.playTime;
                                ans.add(pre2.name);
                            } else {
                                pre2.playTime = pre2.playTime - remain2;
                                stack.push(pre2);
                            }
                        }
                    }
                }
                
                stack.push(new Assignment(plans[i][0], 
                                              convertToInt(plans[i][1]), 
                                              Integer.parseInt(plans[i][2])));
            } else {
                stack.push(
                    new Assignment(plans[i][0], 
                                   convertToInt(plans[i][1]), 
                                   Integer.parseInt(plans[i][2])));
            }
            
            while (!stack.isEmpty()) {
                ans.add(stack.pop().name);
            }
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
