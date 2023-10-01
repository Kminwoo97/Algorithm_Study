import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] arr = new String[files.length][3];
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            
            int j = 0;
            int headEnd = 0;
            int numStart = 0;
            int tailStart = 0;
            
            while (j < file.length()) {
                
                if (headEnd == 0) {
                    if (file.charAt(j) >= 48 && file.charAt(j) < 58) {
                        arr[i][0] = file.substring(0, j);
                        headEnd = j;

                        numStart = j;
                    }
                }
                
                if (numStart != 0) {
                    if (file.charAt(j) < 48 || file.charAt(j) >= 58) {
                        arr[i][1] = file.substring(numStart, j);
                        numStart = 0;
                        tailStart = j;
                    }
                }
                
                if (tailStart != 0) {
                    arr[i][2] = files[i].substring(tailStart);
                    break;
                }
                
                j++;
            }
            
            if (tailStart == 0) {
                arr[i][1] = file.substring(numStart);
            }
        }
        
        Arrays.sort(arr, (e1, e2) -> {
            String s1 = e1[0].toLowerCase();
            String s2 = e2[0].toLowerCase();
            
            if (s1.equals(s2)) {
                return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
            }
                
            return s1.compareTo(s2);
        });

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i][0] + arr[i][1];
            
            if (arr[i][2] != null) {
                answer[i] += arr[i][2];
            }
        }
        
        return answer;
    }
}
