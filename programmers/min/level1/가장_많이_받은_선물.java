import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        int n = map.size();
        
        int[][] arr = new int[n][n];
        for(int i=0; i<gifts.length; i++){
            int a = map.get(gifts[i].split(" ")[0]);
            int b = map.get(gifts[i].split(" ")[1]);
            
            //a가 b에게 선물을 주다.
            arr[a][b]++;
        }
        
        
        int[] cnt = new int[n];
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                if(arr[i][j] > arr[j][i]){
                    //i가 j에게 선물을 받는다.
                    ++cnt[i];
                }else if(arr[i][j] < arr[j][i]){
                    //j가 i에게 선물을 받는다.
                    ++cnt[j];
                }else if(arr[i][j] == arr[j][i]){
                    //선물지수 비교
                    int score_i= GetGiftScore(arr, i);
                    int score_j = GetGiftScore(arr, j);
                    
                    if(score_i > score_j){
                        ++cnt[i];
                    }else if(score_i < score_j){
                        ++cnt[j];
                    }
                }
            }
        }
        
        Arrays.sort(cnt);
        
        
        answer = cnt[n-1];
        
        return answer;
    }
    
    public int GetGiftScore(int[][] arr ,int x){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[x][i];
            sum -= arr[i][x];
        }
        
        return sum;
    }
}
