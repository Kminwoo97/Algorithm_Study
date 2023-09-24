class Solution {
    static int[] count = new int[2];
    static int[][] divide = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        recursive(arr);
        
        return answer = count;
    }
    
    public void recursive(int[][] arr) {
        
        int first = arr[0][0];
        boolean isEqual = true;
        
        if (arr.length == 1) {
            count[first]++;
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != first) {
                    isEqual = false;
                    break;
                }
            }
        }
        
        if (isEqual) {
            count[first]++;
        } else {
            for (int i = 0; i < 4; i++) {
                int len = arr.length / 2;
                int[][] sub = new int[len][len];
                
                for (int j = 0; j < len; j++) {
                    for (int k = 0; k < len; k++) {
                        sub[j][k] = arr[j + len * divide[i][0]][k + len * divide[i][1]];
                    }
                }

                recursive(sub);
            }
        }
    }
}
