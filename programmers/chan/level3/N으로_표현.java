class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        int answer = 0;
        
        dfs(N, number, 0, 0);
        
        return answer = min;
    }
    
    public void dfs(int N, int number, int depth, int sum) {
        if (depth > 8) {
            min = -1;
            return;
        }
        
        if (number == sum) {
            min = Math.min(min, sum);
            return;
        }
        
        dfs(N, number, depth + 1, sum + 5);
        dfs(N, number, depth + 1, sum - 5);
        dfs(N, number, depth + 1, sum * 5);
        dfs(N, number, depth + 1, sum / 5);
    }
}
