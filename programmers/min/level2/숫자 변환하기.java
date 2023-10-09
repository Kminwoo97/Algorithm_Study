class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1];
        
        //현재값(i)에서 i-n, i/2, i/3 위치에서 가장 작은값 가져와서 + 1, 만들 수 없는 숫자라면 MAX 값으로
        for(int i=x+1; i<=y; i++){
            
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            int minValue;
            
            if(i - n >= x)
                a = dp[i - n];
            
            if(i % 2 == 0 && i / 2 >= 1 && i / 2 >= x)
                b = dp[i / 2];
            
            if(i % 3 == 0 && i / 3 >= 1 && i / 3 >= x)
                c = dp[i / 3];
            
            minValue = Math.min(a,b);
            minValue = Math.min(minValue,c);
            
            //만들 수 있는 숫자라면 minValue + 1, 그렇지 않으면 MAX
            if(minValue != Integer.MAX_VALUE){
                dp[i] = minValue + 1;
            }
            else{
                dp[i] = Integer.MAX_VALUE;
            }
        }
        
        if(dp[y] != Integer.MAX_VALUE)
            answer = dp[y];
        else
            answer = -1;
        

        
        return answer;
    }
}
