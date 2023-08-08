class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;

        for (int i = 0; i < sizes.length; i++) {
            int cardMax = Math.max(sizes[i][0], sizes[i][1]);
            int cardMin = Math.min(sizes[i][0], sizes[i][1]);

            max = Math.max(max, cardMax);
            min = Math.max(min, cardMin);
        }

        return answer = max * min;
    }
}