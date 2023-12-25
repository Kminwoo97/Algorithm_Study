import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[col-1] == b[col-1])
                    return b[0] - a[0];
                
                return a[col-1] - b[col-1];
            }
        });
        
        
        int[] val = data[row_begin-1];
        for(int i=0; i<val.length; i++){
            answer += val[i] % row_begin;
        }
        
        for(int i=row_begin; i<row_end; i++){
            val = data[i];
            int sum = 0;
            for(int j=0; j<val.length; j++){
                sum += val[j] % (i+1);
            }
            
            answer = answer ^ sum;
        }
        
        
        return answer;
    }
}
