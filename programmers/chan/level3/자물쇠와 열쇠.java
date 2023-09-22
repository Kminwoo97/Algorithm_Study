import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length;
        int m = key.length;
        int grooveCount = 0;
        int[] init = new int[2];
        List<int[]> list = new ArrayList<>(); // key의 돌기 부분 위치 저장할 리스트
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 0) {
                    grooveCount++;
                }
            }
        }
        
        if (grooveCount == 0) {
            return true;
        }
        
        // key의 돌기 위치 구하기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (key[i][j] == 1) {
                    if (list.size() == 0) {
                        init[0] = i;
                        init[1] = j;
                    }
                    
                    list.add(new int[]{i - init[0], j - init[1]});
                }
            }
        }
        
        // 회전
        for (int i = 0; i < 4; i++) {
            List<int[]> sub = new ArrayList<>();
            
            for (int j = 0; j < list.size(); j++) {
                int x = list.get(j)[0];
                int y = list.get(j)[1];
                
                int temp = x;
                x = y;
                y = -temp;
                
                sub.add(new int[]{x, y});
            }
            
            list = sub;
            
            // 위치 이동하면서 홈 찾기
            for (int j = -n + 1; j < n + m - 1; j++) {
                for (int k = -n + 1; k < n + m - 1; k++) {
                    // 리스트에 있는 값을 이동
                    
                    int count = 0;
                    boolean isMatched = true;
                    
                    for (int[] point : sub) {
                        int x = point[0] + j;
                        int y = point[1] + k;
                        
                        if (x >= 0 && x < n &&
                            y >= 0 && y < n) {
                            
                            if (lock[x][y] == 0) {
                                count++;
                            } else {
                                isMatched = false;
                                break;
                            }
                        }
                    }
                    
                    if (isMatched && count == grooveCount) {
                        answer = true;
                    }
                    
                }
            }
        }
        
        return answer;
    }
}
