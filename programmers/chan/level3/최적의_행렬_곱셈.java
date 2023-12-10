import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < matrix_sizes.length; i++) {
            list.add(matrix_sizes[i]);
        }
                
        while (list.size() > 1) {
            int minSum = Integer.MAX_VALUE;
            int minMulti = Integer.MAX_VALUE;
            int minIndex = 0;
            
            // 이전 값과 현재 값의 요소를 더한 값, 곱한 값이 최소가 되는 것 부터 먼저 계산
            for (int i = 1; i < list.size(); i++) {
                int[] pre = matrix_sizes[i - 1];
                int[] cur = matrix_sizes[i];

                int sum = pre[0] + pre[1] + cur[1];
                int multi = pre[0] * pre[1] * cur[1];

                if (minSum >= sum) {
                    if (minSum > sum) {
                        minSum = sum;
                        minMulti = multi;
                        minIndex = i;
                    } else {
                        if (minMulti > multi) {
                            minMulti = multi;
                            minIndex = i;
                        }
                    }
                }
            }
            
            int[] now = list.get(minIndex);
            int[] left = list.get(minIndex -1);
            
            list.add(minIndex - 1, new int[]{left[0], now[1]});
            list.remove(minIndex);
            list.remove(minIndex);
            
            answer += minMulti;
        }
        
        return answer;
    }
}
