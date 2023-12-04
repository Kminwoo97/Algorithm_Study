import java.util.*;

class Solution {
    static int[][] dist;
    
    public int solution(String[] board) {
        int answer = 0;
        int[] moveX = {0, 0, -1, 1}; // 상하좌우
        int[] moveY = {1, -1, 0, 0}; 
        int[] start = {-1, -1};
        int[] goal = {-1, -1};
        dist = new int[board.length][board[0].length()];
        
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                
                if (board[i].charAt(j) == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
                
                if (start[0] != -1 && start[1] != -1 &&
                    goal[0] != -1 && goal[1] != -1) {
                    break;
                }
            }
        }
        
        dist[start[0]][start[1]] = 0;
        
        bfs(board, start, goal, moveX, moveY);
        
        if (dist[goal[0]][goal[1]] == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = dist[goal[0]][goal[1]];
        }
        
        return answer;
    }
    
    public void bfs (String[] board, int[] start, int[] goal, int[] moveX, int[] moveY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start[0], start[1], 0));
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + moveY[i];
                int nextX = cur.x + moveX[i];
                int preY = -1;
                int preX = -1;

                // 장애물 or 맨 끝에 부딪힐 때 까지 미끄러져 이동한다. 
                while (nextY >= 0 && nextY < board.length &&
                       nextX >= 0 && nextX < board[0].length() &&
                       board[nextY].charAt(nextX) != 'D') {
                    
                    preY = nextY;
                    preX = nextX;
                    nextY += moveY[i];
                    nextX += moveX[i];
                }

                if (preY != -1 && preX != -1 && dist[preY][preX] > cur.count + 1) {
                    dist[preY][preX] = cur.count + 1;
                    q.add(new Point(preY, preX, cur.count + 1));
                }
            }
        }
    }
}

class Point {
    int y;
    int x;
    int count;
    
    public Point(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}
