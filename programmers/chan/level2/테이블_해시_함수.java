import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[] sum = new int[data.length];
        
        // 1. 정렬
        Arrays.sort(data, (e1, e2) -> {
            if (e1[col - 1] == e2[col - 1]) {
                return e2[0] - e1[0];
            }
            
            return e1[col - 1] - e2[col - 1];
        });
        
        // 2. S_i 구하기
        int temp = -1;
        
        for (int i = row_begin - 1; i < row_end; i++) {
            for (int j = 0; j < data[0].length; j++) {
                sum[i] += data[i][j] % (i + 1);
            }
            
            // 3. XOR연산
            if (temp == -1) {
                temp = sum[i];
            } else {
                temp ^= sum[i];
            }
        }
        
        return answer = temp;
    }
}
