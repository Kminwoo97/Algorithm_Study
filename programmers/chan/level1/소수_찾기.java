class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isVisited = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if (isVisited[i] == false) {
                answer++;
                
                for (int j = 1; i * j <= n; j++) {
                    isVisited[i * j] = true;
                }
            }
        }   
        
        return answer;
    }
}
