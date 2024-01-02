class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = num++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            answer[i] = rotate(arr, x1, y1, x2, y2);
        }
        
        return answer;
    }
    
    public int rotate(int[][] arr, int x1, int y1, int x2, int y2){
        int minValue = Integer.MAX_VALUE;
        int tmp = arr[x1][y1];
        
        //왼쪽 아래 -> 왼쪽 위
        for(int i=x1; i<x2; i++){
            arr[i][y1] = arr[i+1][y1];
            
            if(minValue > arr[i][y1])
                minValue = arr[i][y1];
        }
        
        //오른쪽 아래 -> 왼쪽 아래
        for(int i=y1; i<y2; i++){
            arr[x2][i] = arr[x2][i+1];
            
            if(minValue > arr[x2][i])
                minValue = arr[x2][i];
        }
        
        //오른쪽 위 -> 오른쪽 아래
        for(int i=x2; i>x1; i--){
            arr[i][y2] = arr[i-1][y2];
            
            if(minValue > arr[i][y2])
                minValue = arr[i][y2];
        }
        
        //왼쪽 위 -> 오른쪽 위
        for(int i=y2; i>y1+1; i--){
            arr[x1][i] = arr[x1][i-1];
            
            if(minValue > arr[x1][i])
                minValue = arr[x1][i];
        }
        
        arr[x1][y1+1] = tmp;
        
        if(minValue > arr[x1][y1+1])
            minValue = arr[x1][y1+1];
        
        return minValue;
    }
}
