import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int n;
    int m;
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        bfs(maps, 0, 0);
        
        if(maps[n-1][m-1] != 1)
            answer = maps[n-1][m-1];
        
        return answer;
    }
    
    public void bfs(int[][] maps, int a, int b){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        visited[a][b] = true;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                if(maps[nx][ny] == 0)
                    continue;
                
                if(visited[nx][ny])
                    continue;
                
                visited[nx][ny] = true;
                maps[nx][ny] = maps[x][y] + 1;
                q.offer(new Node(nx,ny));
            }
        }
    }
}

class Node{
    public int x;
    public int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
