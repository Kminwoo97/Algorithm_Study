class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] prons = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++) {
            String str = babbling[i];
            int len = str.length();
            boolean isConsecutive = false;
            int[] count = new int[4];
            
            while (true) {
                for (int j = 0; j < 4; j++) {
                    int originalLen = str.length();
                    
                    str = str.replace(prons[j], j + "");
                    
                    if (originalLen != str.length()) {
                        count[j]++;
                    }
                    
                    // 연속된 발음이 있는 경우
                    if (str.length() != str.replace(j + "" + j, "").length()) {
                        isConsecutive = true;
                        break;
                    }
                }
                
                if (isConsecutive == true) {
                    break;
                }
                
                String sub = str;
                for (int j = 0; j < 4; j++) {
                    if (count[j] > 0) {
                        while (count[j] != 0) {
                            sub = sub.replace(j + "", "");
                            count[j]--;
                        }    
                    }
                    
                    if (sub.equals("")) {
                        answer++;
                        break;
                    }
                }
                
                // 발음할 수 있는경우
                if (len != str.length()) {
                    len = str.length();
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}
