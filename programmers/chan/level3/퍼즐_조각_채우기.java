import java.util.*;

class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    static int[] moveX = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] moveY = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
    
        // 1. game_board의 도형 모양 찾기
        List<List<int[]>> blanks = getPuzzles(game_board, 0);
        
        // 2. table의 도형 모양 찾기
        List<List<int[]>> puzzles = getPuzzles(table, 1);
        
        boolean[] isFitted = new boolean[blanks.size()];
        boolean[] isUsed = new boolean[puzzles.size()];
            
        for (int i = 0; i < blanks.size(); i++) {
            List<int[]> blankList = blanks.get(i);
            
            for (int j = 0; j < puzzles.size(); j++) {
                List<int[]> puzzleList = puzzles.get(j);
                if (blankList.size() == puzzleList.size() && isFitted[i] == false && isUsed[j] == false) {
                    boolean match = isMatched(blankList, puzzleList);

                    if (match) {
                        isFitted[i] = true;
                        isUsed[j] = true;
                        answer += blankList.size();
                        System.out.println(blankList.size());
                    }
                }
            }
        }
        
        return answer;
    }
    
    public List<int[]> findPuzzle(int[][] table, boolean[][] isVisited, int x, int y, int value) {
        List<int[]> list = new ArrayList<>();
        isVisited[x][y] = true;
        queue.offer(new int[]{x, y});
        list.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + moveX[i];
                int nextY = cur[1] + moveY[i];
                
                if (nextX >= 0 && nextX < isVisited.length && nextY >= 0 && nextY < isVisited.length && 
                    isVisited[nextX][nextY] == false && table[nextX][nextY] == value) {

                    isVisited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                    list.add(new int[]{nextX - x, nextY - y}); // 도형 위치를 시작지점(0, 0) 으로 몰아주기 위해 최초 x, y값 빼줌
                }
            }
        }
        
        return list;
    }
    
    public List<List<int[]>> getPuzzles(int[][] table, int value) {
        boolean[][] isVisited = new boolean[table.length][table.length];
        List<List<int[]>> puzzles = new ArrayList<>();
            
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (isVisited[i][j] == false && table[i][j] == value) {
                    List<int[]> puzzleList = findPuzzle(table, isVisited, i, j, value);
                    
                    Collections.sort(puzzleList, (e1, e2) -> {
                        if (e1[0] == e2[0]) {
                            return e1[1] - e2[1];
                        }
                        
                        return e1[0] - e2[0];   
                    });
                    
                    puzzles.add(puzzleList);
                }
            }
        }
        
        return puzzles;
    }
    
    public boolean isMatched(List<int[]> blankList, List<int[]> puzzleList) {
        boolean match = true;
        
        for (int i = 0; i < 4; i++) {
            List<int[]> list = new ArrayList<>();
            match = true;
            
            for (int[] puzzle : puzzleList) {
                // (x, y) -> (y, -x)
                int temp = puzzle[0];
                puzzle[0] = puzzle[1];
                puzzle[1] = -temp;
                
                list.add(puzzle);
            }

            Collections.sort(list, (e1, e2) -> {
                if (e1[0] == e2[0]) {
                    return e1[1] - e2[1];
                }
                        
                return e1[0] - e2[0];   
            });
            
            List<int[]> sub = new ArrayList<>();
            
            int minX = list.get(0)[0];
            int minY = list.get(0)[1];
            
            for (int[] e : list) {
                e[0] -= minX;
                e[1] -= minY;
                
                sub.add(new int[]{e[0], e[1]});
            }
                        
            for (int j = 0; j < blankList.size(); j++) {
                int[] blank = blankList.get(j);
                int[] puzzle = sub.get(j);
                
                if (puzzle[0] != blank[0] || puzzle[1] != blank[1]) {
                    match = false;
                    break;
                }
            }
            
            if (match) {
                break;
            }
        }
        
        return match;
    }
}
