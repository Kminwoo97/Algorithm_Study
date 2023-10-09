class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int count = 0;
        int[][] point = new int[2][2];
        point[0][1] = 50;
        point[1][1] = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    count++;

                    if (count == 1) {
                        point[0][0] = i;
                    }
                    
                    if (point[0][1] >= j) {
                        point[0][1] = j;
                    }
                    
                    if (point[1][1] <= j + 1) {
                        point[1][1] = j + 1;
                    }
                    
                    point[1][0] = i + 1;
                }
            }
        }
        
        answer[0] = point[0][0];
        answer[1] = point[0][1];
        answer[2] = point[1][0];
        answer[3] = point[1][1];
        
        return answer;
    }
}
