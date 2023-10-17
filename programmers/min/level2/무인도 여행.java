import java.util.*;
class Solution {
    
    boolean[][] visited;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int n;
    int m;
    
    public int[] solution(String[] maps) {
        int[] answer = {-1};
        
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //무인도이고 방문하지 않았다면 탐색시작
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    int x = bfs(i,j,maps);
                    list.add(x);
                }
            }
        }
        
        if(!list.isEmpty()){
            Collections.sort(list);
            answer = list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        }
        
        return answer;
    }
    
    public int bfs(int x, int y, String[] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        int value = Integer.parseInt(String.valueOf(maps[x].charAt(y)));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위를 벗어나면 continue
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                //무인도이고 방문하지 않았다면 큐에 추가한다.
                if(maps[nx].charAt(ny) != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx,ny));
                    value += Integer.parseInt(String.valueOf(maps[nx].charAt(ny)));
                }
            }
        }
        
        return value;
    }
}

class Node{
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
