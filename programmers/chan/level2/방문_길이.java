import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] dir = {'U', 'D', 'R', 'L'};
        int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        // 시작위치 (5, 5)와 도착지점 (x, y)를 List<int[]>[][] 자료형에 저장
        // dirs 진행하면서 범위를 안 넘어가면 이동하고 boolean이 false면 answer++
        
        List<int[]>[][] list = new ArrayList[11][11];
        
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        
        int curX = 5;
        int curY = 5;
        
        for (int i = 0; i < dirs.length(); i++) {
            for (int j = 0; j < 4; j++) {
                if (dirs.charAt(i) == dir[j]) {                    
                    int nextX = curX + move[j][0];
                    int nextY = curY + move[j][1];
                    
                    if (nextX >= 0 && nextX < 11 && nextY >= 0 && nextY < 11) {
                        int[] next = {nextX, nextY};
                        int size = list[curX][curY].size();
                        boolean isVisited = false;
                            
                        for (int k = 0; k < size; k++) {
                            int[] element = list[curX][curY].get(k);

                            if (Arrays.equals(element, next)) {
                                isVisited = true;
                                
                                break;
                            }
                        }
                            
                        if (isVisited == false) {
                            list[curX][curY].add(next);
                            list[nextX][nextY].add(new int[]{curX, curY});
                                
                            answer++;
                        }
                        
                        curX = nextX;
                        curY = nextY;
                    }
                    
                    break;
                }
            }
        }
    
        return answer;
    }
}