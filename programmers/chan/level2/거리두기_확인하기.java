class Solution {
    static int[] moveX = {0, 0, 1, 2, 1}; // 하하우우 대각(우측하단)
    static int[] moveY = {1, 2, 0, 0, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            boolean[][] isVisited = new boolean[5][5];
            boolean flag = true;
            
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    char p = places[i][j].charAt(k);

                    if (p == 'P' && isVisited[j][k] == false) {
                        isVisited[j][k] = true;
                        
                        if (!isComplied(places[i], isVisited, new int[]{j, k})) {
                            flag = false;
                            break;
                        }
                    }
                }
                
                if (!flag) {
                    break;
                }
            }
            
            if (flag) {
                answer[i] = 1;
            } else {
                answer[i] = 0;   
            }
        }
        
        return answer;
    }
    
    public boolean isComplied(String[] places, boolean[][] isVisited, int[] cur) {
        boolean flag = true;
        
        for (int i = 0; i < 5; i++) {
            int nextY = cur[0] + moveY[i];
            int nextX = cur[1] + moveX[i];
            
            if (nextY >= 0 && nextY < 5 && nextX >= 0 & nextX < 5 &&
                places[nextY].charAt(nextX) == 'P' &&
                isVisited[nextY][nextX] == false) {
                
                isVisited[nextY][nextX] = true;
                
                // 맨해튼 거리가 2인 경우
                if (i != 0 && i != 2) {
                    // 대각선에 앉은 경우
                    if (i == 4) {
                        // 바로 오른쪽 칸과 아래 칸에 파티션 있는지 확인
                        int dPointY = cur[0] + moveY[0];
                        int dPointX = cur[1] + moveX[0];
                        
                        int rPointY = cur[0] + moveY[2];
                        int rPointX = cur[1] + moveX[2];
                        
                        if (places[dPointY].charAt(dPointX) != 'X' || places[rPointY].charAt(rPointX) != 'X') {
                            flag = false;
                            break;
                        }
                    } else {
                        // 아래 두 칸 띄고 앉은 경우
                        if (i == 1) {
                            // 바로 아래칸에 파티션 있는지 확인
                            int pointY = cur[0] + moveY[0];
                            int pointX = cur[1] + moveX[0];
                            
                            if (places[pointY].charAt(pointX) != 'X') {
                                flag = false;
                                break;
                            }
                        } else {
                            // 오른쪽 두 칸 띄고 앉은 경우
                            // 바로 오른쪽 칸에 파티션 있는지 확인
                            int pointY = cur[0] + moveY[2];
                            int pointX = cur[1] + moveX[2];
                            
                            if (places[pointY].charAt(pointX) != 'X') {
                                flag = false;
                                break;
                            }
                        }
                    }
                } else {
                    flag = false;
                    break; 
                }
            }
        }
        
        return flag;
    }
}
