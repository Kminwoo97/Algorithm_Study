class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        
        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            
            sb.append(max);
        }

        return answer = sb.toString();
    }
}
