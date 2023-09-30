import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        //행동 3가지 - 아래, 오른쪽, 왼쪽 대각선
        int[] dx = new int[]{1,0,-1};
        int[] dy = new int[]{0,1,-1};
        
        int[][] triangle = new int[n][n];
        int x=0;
        int y=0;
        int val=0;
        int d=0;
        while(true){
            triangle[x][y] = ++val;
            
            //현재 가는 방향으로 갔을 때 범위를 벗어났거나 이미 방문처리한 경우는 방향전환을 한다.
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx == n || ny == n || triangle[nx][ny] != 0){
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                
                //방향전환 했음에도 불구하고 동일한 상황이면 모든 지점을 처리한 겻이다. break
                if(nx == n || ny == n || triangle[nx][ny] != 0){
                    break;
                }
            }
            
            x = nx;
            y = ny;
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                list.add(triangle[i][j]);
            }
        }
        answer = list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        
        return answer;
    }
}
