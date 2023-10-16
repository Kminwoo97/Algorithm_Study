class Solution {
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        
        dfs(n - 2, 2);
        
        return answer;
    }
    
    public void dfs(int n, int plusCnt) {
        if (n == 3) {
            if (plusCnt == 2) {
                answer++;
            }
            
            return;
        }
        
        if (n < 1 || 2 * Math.log(n) / Math.log(3) < plusCnt) {
            return;
        }
        
        if (n % 3 == 0 && plusCnt >= 2) {
            dfs(n / 3, plusCnt - 2);
        }
        
        dfs(n - 1, plusCnt + 1);
    }
}
