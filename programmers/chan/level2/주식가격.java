class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // prices의 각 요소를 비교한다.
        // 1. prices[i]에서 인덱스를 증가해가면서 뒤의 값과 비교한다.
        // 2. prices[i]보다 작다면 해당 인덱스 값 - i 하면 가격이 떨어지지않은 기간이 나온다.
        // 3. 끝까지 진행했을때 isDowned가 false라면 prices.length - 1 - i 하여 가격이 떨어지지않은 기간을 구할 수 있다.
        
        for (int i = 0; i < prices.length; i++) {
            boolean isDowned = false;
            
            for (int j = i; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    isDowned = true;
                    break;
                }
            }
            
            if (isDowned == false) {
                answer[i] = prices.length - 1 - i;
            }
        }
        
        return answer;
    }
}