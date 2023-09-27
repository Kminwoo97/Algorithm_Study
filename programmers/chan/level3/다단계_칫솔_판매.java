import java.util.*;

class Solution {
    static int[] answer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            dfs(referral, map, seller[i], map.get(seller[i]), amount[i] * 100);
        }

        return answer;
    }
    
    public void dfs(String[] referral, Map<String, Integer> map, String sellerName, int index, int money) {
        String referralName = referral[index];
        int referralFee = money / 10;
            
        if (referralName.equals("-")) {
            answer[index] += money - referralFee;
            return;
        }
        
        if (referralFee != 0) {
            dfs(referral, map, referralName, map.get(referralName), referralFee);
        }
        
        answer[index] += money - referralFee;
    }
}
