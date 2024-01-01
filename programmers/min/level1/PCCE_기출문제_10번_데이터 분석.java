
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        
        int ext_index = getIndex(ext); 
        ArrayList<int[]> filtered_list = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            if(data[i][ext_index] < val_ext){
                filtered_list.add(data[i]);
            }
        }
        
        int sort_index = getIndex(sort_by);
        Collections.sort(filtered_list, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[sort_index] - b[sort_index];
            }
        });
        
        answer = filtered_list.toArray(new int[0][]);
        
        return answer;
    }
    
    public int getIndex(String x){
        int i = -1;
        switch(x){
            case "code":
                i = 0;
                break;
            case "date":
                i = 1;
                break;
            case "maximum":
                i = 2;
                break;
            case "remain":
                i = 3;
                break;      
        }
        return i;
    }
}
