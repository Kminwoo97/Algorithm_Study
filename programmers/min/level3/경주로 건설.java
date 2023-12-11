import java.util.*;

class Solution {
    
    boolean[][][] visited;
    int n;
    int[] dx = {-1, 1, 0 , 0};
    int[] dy = {0, 0, -1, 1};
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        
        n = board.length;
        visited = new boolean[n][n][4];
        bfs(board, 0,0);
        
        
        return answer;
    }
    
    public void bfs(int[][] board, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0, -1});
        
        while(!q.isEmpty()){
            int[] load = q.poll();
            x = load[0];
            y = load[1];
            int cost = load[2];
            int dir = load[3];
            
            //종료 조건
            if(x == n-1 && y == n-1){
                answer = Math.min(answer, cost);
            }
            
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위를 벗어나면 패스
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                
                //벽을 만나면 패스
                if(board[nx][ny] == 1)
                    continue;
                
                
                //도로건설 비용 계산
                int n_cost = cost;
                if(dir == i || dir == -1){  
                    n_cost += 100;
                }else{
                    n_cost += 600;
                }
                
                //다른 경로로 도로를 건설한 비용보다 현재 건설 비용이 싸다면 Queue에 담는다.
                if(!visited[nx][ny][i] || board[nx][ny] >= n_cost){
                    visited[nx][ny][i] = true;
                    board[nx][ny] = n_cost;
                    q.offer(new int[]{nx,ny, n_cost, i});
                }
            }
        }
    }
}
