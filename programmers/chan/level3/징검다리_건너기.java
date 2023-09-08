import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        // 0이 k번 연속으로 나오는 구간을 체크.
        // 각 원소가 x 보다 작은 경우가 k 번 연속으로 이어지는 최소구간을 구함
        // x 보다 작은 경우가 k 번 연속 이어지는 구간이 없다면 x를 up, 있다면 down
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int stone : stones) {
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }
        
        while (min <= max) {
            int x = (min + max + 1) / 2;
            int count = 0;
            boolean canMove = true;
            
            for (int i = 0; i < stones.length; i++) {
                if (x > stones[i]) { // 돌을 못 건너는 경우
                    count++;
                } else {
                    count = 0;
                }
                
                if (count == k) {
                    canMove = false;
                    break;
                }
            }
            
            if (canMove) {
                min = x + 1;
            } else {
                max = x - 1;
            }
        }
        
        return answer = max;
    }
}
