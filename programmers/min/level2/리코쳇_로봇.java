import java.util.*;

class Solution {
    
    int n,m;
    boolean[][] visited;
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        visited = new boolean[n][m];
        
        //로봇의 출발위치 찾기
        int x = -1;
        int y = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j) == 'R'){
                    x = i;
                    y = j;
                }
            }
        }
        
        answer = bfs(board, x, y, 'G');
        
        return answer;
    }
    
    public int bfs(String[] board, int x, int y, char target){
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        q.offer(new int[]{x, y, cnt});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            x = point[0];
            y = point[1];
            cnt = point[2];
            
            if(board[x].charAt(y) == 'G'){
                return cnt;
            }
            
            for(int i=0; i<4; i++){
                int nx = x;
                int ny = y;
                
                //벽을 만나거나 장애물을 만나기 직전까지 미끄러진다.
                while(!(nx + dx[i] >= n || nx + dx[i] < 0 || 
                           ny + dy[i] >=m || ny + dy[i] < 0 || 
                  board[nx + dx[i]].charAt(ny + dy[i]) == 'D')){
                    
                    nx += dx[i];
                    ny += dy[i];
                }
                
                if(!visited[nx][ny]){
                    q.offer(new int[]{nx, ny, point[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}
