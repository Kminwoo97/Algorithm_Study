class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrimeNumber(nums[i], nums[j], nums[k]) == true) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    public boolean isPrimeNumber(int a, int b, int c) {
        int sum = a + b + c;
        
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
