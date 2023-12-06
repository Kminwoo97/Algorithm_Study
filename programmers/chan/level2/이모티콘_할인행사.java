import java.util.*;

class Solution {
    static int[] discountRate = {40, 30, 20, 10};
    static int[] answer;

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        
        dfs(users, emoticons, new boolean[emoticons.length], new ArrayList<>(), 0);
        
        return answer;
    }
    
    public void dfs(int[][] users, int[] emoticons, boolean[] isVisited, List<int[]> prices, int start) {
    
        if (prices.size() == emoticons.length) {
            int userCount = 0;
            int totalSales = 0;
            
            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                
                for (int j = 0; j < prices.size(); j++) {
                    int[] price = prices.get(j);
                    
                    if (users[i][0] <= price[0]) {
                        sum += price[1] - price[1] * price[0] / 100;
                    }
                }
                
                if (sum >= users[i][1]) {
                    userCount++;
                } else {
                    totalSales += sum;
                }
            }
            
            if (answer[0] < userCount) {
                answer[0] = userCount;
                answer[1] = totalSales;
            } else if (answer[0] == userCount) {
                if (answer[1] < totalSales) {
                    answer[1] = totalSales;
                }
            }
            
            return;
        }
        
        for (int i = start; i < 4; i++) {
            for (int j = 0; j < emoticons.length; j++) {
                if (isVisited[j] == false) {
                    isVisited[j] = true;
                    List<int[]> sub = new ArrayList<>(prices);
                    sub.add(new int[]{discountRate[i], emoticons[j]});
                    
                    dfs(users, emoticons, isVisited, sub, i);
                    isVisited[j] = false;
                }
            }
        }
    }
}
