import java.util.*;

class Solution {
    
    int[] dx = new int[]{0,1,0,-1};
    int[] dy = new int[]{1,0,-1,0};
    int n,m;
    boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        //초기화
        n = maps.length;
        m = maps[0].length();
        
        //START, 레버 위치 찾기
        int[] startPoint = new int[2];
        int[] leverPoint = new int[2];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) == 'L'){
                    leverPoint[0] = i;
                    leverPoint[1] = j;
                }
                
                if(maps[i].charAt(j) == 'S'){
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
            }
        }
        
        //START -> 레버
        visited = new boolean[n][m];
        int a = bfs(maps, startPoint[0], startPoint[1], 'L');

        //레버 -> EXIT
        visited = new boolean[n][m];
        int b = bfs(maps, leverPoint[0], leverPoint[1], 'E');
        
        answer = a + b;
        
        if(a == -1 || b == -1)
            answer = -1;
            
        
        
        return answer;
    }
    
    public int bfs(String[] maps, int x, int y, char target){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            x = point[0];
            y = point[1];
            
            if(maps[x].charAt(y) == target){
                return point[2];
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위 벗어나면 패스
                if(nx >= n || nx < 0 || ny >= m || ny < 0)
                    continue;
                
                //벽을 만나면 패스
                if(maps[nx].charAt(ny) == 'X')
                    continue;
                
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, point[2] + 1});
                }
            }
        }
        
        return -1;
    }
}
