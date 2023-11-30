import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        int filterStandard = getTargetIndex(ext);
        int sortStandard = getTargetIndex(sort_by);
        
        List<Integer> indecies = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][filterStandard] < val_ext) {
                indecies.add(i);
            }
        }
        
        Collections.sort(indecies, (e1, e2) -> data[e1][sortStandard] - data[e2][sortStandard]);
        answer = new int[indecies.size()][4];
        
        for (int i = 0; i < indecies.size(); i++) {
            answer[i] = data[indecies.get(i)];
        }
        
        return answer;
    }
    
    public int getTargetIndex(String target) {
        int index = 0;
        
        switch (target) {
            case "date":
                index = 1;
                break;
            case "maximum":
                index = 2;
                break;
            case "remain":
                index = 3;
                break;
            default:
                break;
        }
        
        return index;
    }
}
