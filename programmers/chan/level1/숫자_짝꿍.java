import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        
        while (i < X.length() || i < Y.length()) {
            if (i < X.length()) {
                int num = (int) X.charAt(i) - 48;
                xCount[num]++;
            }
            
            if (i < Y.length()) {
                int num = (int) Y.charAt(i) - 48;
                yCount[num]++;
            }
            
            i++;
        }
        
        for (int j = 9; j >= 0; j--) {
            if (xCount[j] != 0 && yCount[j] != 0) {
                int repeat = Math.min(xCount[j], yCount[j]);
                sb.append(("" + j).repeat(repeat));
            }
        }
        
        if (sb.length() == 0) {
            answer = "-1";
        } else {
            if (sb.charAt(0) == '0') {
                answer = "0";
            } else {
                answer = sb.toString();
            }
        }
        
        return answer;
    }
}
