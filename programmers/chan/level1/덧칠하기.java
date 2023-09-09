class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int pre = section[0];
        
        for (int i = 1; i < section.length; i++) {
            if (section[i] >= pre + m) {
                answer++;
                pre = section[i];
            }
        }
        
        return answer;
    }
}
