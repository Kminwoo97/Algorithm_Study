class Solution
{
    int n,m;
    int answer = 0;
    public int solution(int [][]board){
        
        n = board.length;//행
        m = board[0].length;//열
        
        int[][] newBoard = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                newBoard[i+1][j+1] = board[i][j];
            }
        }
        
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(newBoard[i][j] == 1){
                    newBoard[i][j] = Math.min(newBoard[i-1][j-1],
                                           Math.min(newBoard[i-1][j], newBoard[i][j-1])) + 1;
                    answer = Math.max(answer, newBoard[i][j]);
                }
            }
        }
        
        answer = answer * answer;
        
        return answer;
    }
}
