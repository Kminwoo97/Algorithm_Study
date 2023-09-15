import java.util.*;

class Solution {
    int n;
    boolean[][] visited;
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        n = game_board.length;
        visited = new boolean[n][n];
        
        //게임판에서 비어있는 블록(0) 찾기
        ArrayList<ArrayList<int[]>> emptyList = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(game_board[i][j] == 0 && !visited[i][j]){
                    ArrayList<int[]> list = new ArrayList<>();
                    bfs(i, j, game_board, 0, list);
                    emptyList.add(list);
                }
            }
        }
        
        //테이블에서 블록(1) 찾기
        ArrayList<ArrayList<int[]>> fullList = new ArrayList<>();
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(table[i][j] == 1 && !visited[i][j]){
                    ArrayList<int[]> list = new ArrayList<>();
                    bfs(i, j, table, 1, list);
                    fullList.add(list);
                }
            }
        }
        
        //게임판, 테이블에서 찾은 블록들을 (0,0) 기준으로 옮기기
        for(int i=0; i<emptyList.size(); i++){
            setCenter(emptyList.get(i));
        }
        for(int i=0; i<fullList.size(); i++){
            setCenter(fullList.get(i));
        }
        
        //테이블에서 찾은 블록들을 회전하면서 퍼즐조각에 맞는지 확인
        for(ArrayList<int[]> empty : emptyList){
            for(ArrayList<int[]> full : fullList){
                if(canInsert(empty, full)){
                    answer += full.size();
                    fullList.remove(full);
                    
                    if(fullList.size() == 0){
                        return answer;
                    }
                    
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
    public boolean canInsert(ArrayList<int[]> empty, ArrayList<int[]> full){
        if(empty.size() != full.size())
            return false;
        
        //회전하면서 같은지 확인하기
        for(int i=0; i<3; i++){
            if(isSame(empty, full)){
                return true;
            }
            
            //90도 회전 (x, y) -> (y, -x)
            turn(full);
        }
        
        if(isSame(empty, full)){
            return true;
        }
        
        return false;
        
    }
    
    public boolean isSame(ArrayList<int[]> empty, ArrayList<int[]> full){
        int size = empty.size();
        for(int i=0; i<size; i++){
            
            int j = 0;
            for(; j<size; j++){
                if(empty.get(i)[0] == full.get(j)[0] 
                   && empty.get(i)[1] == full.get(j)[1]){
                    break;
                }
            }
            
            //좌표 값이 다르면 서로 다른 모양이다.
            if(j==size){
                return false;
            }
        }
        return true;
    }
    
    public void turn(ArrayList<int[]> full){
        for(int i=0; i<full.size(); i++){
            int temp = -full.get(i)[0];
            full.get(i)[0] = full.get(i)[1];
            full.get(i)[1] = temp;
        }
        setCenter(full);
    }
    
    public void setCenter(ArrayList<int[]> list){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int i=0; i<list.size(); i++){
            int[] point = list.get(i);
            
            if(point[0] < minX)
                minX = point[0];
            
            if(point[1] < minY)
                minY = point[1];
        }
        
        for(int i=0; i<list.size(); i++){
            list.get(i)[0] -= minX;
            list.get(i)[1] -= minY;
        }
        
        
    }
    
    public void bfs(int x, int y, int[][] board, int target, ArrayList<int[]> list){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        list.add(new int[]{x,y});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위 벗어나면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                
                //방문했거나 찾아야하는 블록이 아닌 경우는 무시
                if(visited[nx][ny] || board[nx][ny] != target)
                    continue;
                
                visited[nx][ny] = true;
                q.offer(new Node(nx,ny));
                list.add(new int[]{nx,ny});
            }
        }
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
