class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] tile = new int[60001];
        tile[1] = 1;
        tile[2] = 2;
        for(int i=3; i<=60000; i++){
            tile[i] = (tile[i-1] + tile[i-2]) % 1000000007;
        }
        
        answer = tile[n];
            
        return answer;
    }
}
