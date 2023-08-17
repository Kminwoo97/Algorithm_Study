import java.util.*;

class Solution {
    static Queue<Point> q = new LinkedList<>();
    static boolean[][] isVisited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        isVisited = new boolean[maps.length][maps[0].length];
        bfs(maps, 0, 0);

        return answer;
    }

    public void bfs(int[][] maps, int x, int y) {
        int sum = 0;

        isVisited[x][y] = true;
        q.add(new Point(x, y, 1));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == maps.length - 1 && p.y == maps[0].length - 1) {
                answer = Math.min(answer, p.sum);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + direction[i][0];
                int nextY = p.y + direction[i][1];

                if (nextX >= 0 && nextX < maps.length &&
                        nextY >= 0 && nextY < maps[0].length &&
                        isVisited[nextX][nextY] == false &&
                        maps[nextX][nextY] == 1) {
                    isVisited[nextX][nextY] = true;
                    q.offer(new Point(nextX, nextY, p.sum + 1));
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
    }
}

class Point{
    int x;
    int y;
    int sum;

    Point (int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}