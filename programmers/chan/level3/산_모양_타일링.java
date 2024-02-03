class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        
        a[0] = 1;
        
        if (tops[0] == 0) {
            b[0] = 2;
        } else {
            b[0] = 3;
        }
        
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            
            if (tops[i] == 1) {
                b[i] = a[i - 1] * 2 + b[i - 1] * 3;                
            } else {
                b[i] = a[i - 1] + b[i - 1] * 2;
            }
            
            a[i] %= 10007;
            b[i] %= 10007;
        }
        
        return answer = (a[n - 1] + b[n - 1]) % 10007;
    }
}
