class Solution {
    public int[] solution(int n, int s) {
        int quot = s / n;
        int remain = s % n;
        
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (remain > 0) {
                arr[i] = quot + 1;
                remain--;
            } else {
                arr[i] = quot;
            }
        }
        
        if (arr[0] == 0) {
            return new int[]{-1};
        }
        
        return arr;
    }
}
