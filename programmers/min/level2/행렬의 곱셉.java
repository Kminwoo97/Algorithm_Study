class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        
        //arr1 행(n) 열(m), arr2 행(m) 열(l)
        //행열의 곱셉 n행m열 x m행k열 -> (n행, l열)
        int n = arr1.length;
        int m = arr1[0].length;
        int l = arr2[0].length;
        
        answer = new int[n][l];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<l; k++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        
        return answer;
    }
}
