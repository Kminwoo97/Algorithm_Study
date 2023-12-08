import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        Queue<int[]> pq = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int[] min = new int[]{-1, Integer.MAX_VALUE};
        
        for (int i = 1; i < matrix_sizes.length; i++) {
            list.add(matrix_sizes[i - 1]);
            
            int multiValue = matrix_sizes[i - 1][0] * matrix_sizes[i][1];
            
            if (min[1] > multiValue) {
                min[0] = i - 1;
                min[1] = multiValue;
            }
        }
        
        list.add(matrix_sizes[matrix_sizes.length - 1]);
        pq.add(min);
        int sum = 0;
        
        while (list.size() > 1) {
            int[] cur = pq.poll();
            
            int[] matrix = list.get(cur[0]);
            sum += cur[1] * matrix[1];
            
            list.add(cur[0], new int[]{matrix[0], list.get(cur[0] + 1)[1]});
            list.remove(cur[0] + 1);
            list.remove(cur[0] + 1);
            
            min[0] = -1;
            min[1] = Integer.MAX_VALUE;
            
            for (int i = 1; i < list.size(); i++) {
                int multiValue = list.get(i - 1)[0] * list.get(i)[1];
                
                if (min[1] > multiValue) {
                    min[0] = i - 1;
                    min[1] = multiValue;
                }
            }
            
            pq.add(min);
        }
        
        return answer = sum;
    }
}
