import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        //2x2 블록 체크를 위한 오른쪽, 오른쪽 대각선 아래, 아래
        int[] dx = new int[]{1,1,0};
        int[] dy = new int[]{0,1,1};
        
        
        //게임판 초기화
        String[][] gameBoard = new String[m][n];
        for(int i=0; i<m; i++){
            String[] input = board[i].split("");
            for(int j=0; j<n; j++)
                gameBoard[i][j] = input[j];
        }
        
        while(true){
            //2x2블록이 찾아지는 (x,y)를 담는 list
            ArrayList<int[]> list = new ArrayList<>();
            
            for(int x=0; x<m-1; x++){
                for(int y=0; y<n-1; y++){
                    //현재 보고 있는 블록이 지워진 블록이라면 패스
                    String cur = gameBoard[x][y];
                    if(cur.equals("#"))
                        continue;
                
                    //2x2 블록인지는 오른쪽, 오른쪽 대각선 아래, 아래를 확인해서 같은지 확인한다.
                    boolean flag = true;
                    for(int i=0; i<3; i++){
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                    
                        if(!gameBoard[nx][ny].equals(cur)){
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag)
                        list.add(new int[]{x,y});
                }
            }
            
            //더 이상 지울 블록이 없으면 탈출
            if(list.size() == 0)
                break;
            
            //블록 지우기
            for(int i=0; i<list.size(); i++){
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                
                if(!gameBoard[x][y].equals("#")){
                    answer++;
                    gameBoard[x][y] = "#";
                }
                
                for(int j=0; j<3; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(!gameBoard[nx][ny].equals("#")){
                        answer++;
                        gameBoard[nx][ny] = "#";
                    }
                }
            }
            
            //블록 땡기기
            for(int i=m-1; i>=0; i--){
                for(int j=0; j<n; j++){
                    if(gameBoard[i][j].equals("#")){
                        for(int k=i; k>=0; k--){
                            if(gameBoard[k][j].equals("#"))
                                continue;
                            gameBoard[i][j] = gameBoard[k][j];
                            gameBoard[k][j] = "#";
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
