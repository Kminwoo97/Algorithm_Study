import java.util.*;

class Solution {
    
    boolean[][] visited;
    int n;
    int m;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] oilGroup;
    Map<Integer, Integer> oilAmount = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oilGroup = new int[n][m];
        
        int number = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(land, i, j, number);
                    number++;
                }
            }
        }
        
        //시추관 삽입
        for(int j=0; j<m; j++){
            
            int tmp = 0;
            boolean[] groupVisited = new boolean[oilAmount.size() + 1];
            for(int i=0; i<n; i++){
                if(land[i][j] == 1){
                    int g_number = oilGroup[i][j];
                    if(!groupVisited[g_number]){
                        groupVisited[g_number] = true;
                        tmp += oilAmount.get(g_number);
                    }
                }
            }
            
            answer = Math.max(answer, tmp);
        
        }
        
        return answer;
    }
    
    public void bfs(int[][] land, int x, int y, int number){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        
        ArrayList<int[]> list = new ArrayList<>();
        while(!q.isEmpty()){
            int[] node = q.poll();
            
            x = node[0];
            y = node[1];
            list.add(new int[]{x,y});
            
            //석유 그룹 번호 매기기
            oilGroup[x][y] = number;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위 벗어나면 continue
                if(nx < 0 || nx >= n || ny < 0 || ny >=m)
                    continue;
                
                //석유가 아니라면 continue
                if(land[nx][ny] == 0)
                    continue;
                
                if(!visited[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        //석유 번호 - 석유 양
        oilAmount.put(number, list.size());
    }
}
