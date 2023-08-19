class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int matchesCount = 0;
        int zeroCount = 0;
        int max, min;
        
        // 1. win_nums와 lottos를 비교하여 일치하는 번호 갯수 저장 => matchesCount
        // 2. lottos에서 0의 갯수 구해서 => zeroCount
        // 3. win_nums에서 일치하는 번호를 제외하고 남은 갯수 - zeroCount의 최대, 최소값을 구한다.
        
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    matchesCount++;
                }
            }
        }
        
        max = matchesCount + zeroCount;
        min = matchesCount;
        
        answer[0] = getRank(max);
        answer[1] = getRank(min);
            
        return answer;
    }
    
    public int getRank(int n) {
        if (n <= 1) {
            return 6;
        } else {
            return 6 - n + 1;
        }
    }
}