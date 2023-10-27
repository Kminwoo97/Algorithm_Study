import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] tomato;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<int[]> q = new LinkedList<>();

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //가로(열), 세로(행) 입력
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++){
                //익은 토마토를 Queue에 넣는다.
                if (tomato[i][j] == 1) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        //익은 토마토를 큐에 넣은 상태로 bfs 를 시작한다.
        bfs();

        //정답 도출
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //토마토가 익지 않은 상황이라면 -1 출력하고 종료
                if(tomato[i][j] == 0){
                    System.out.println(-1);
                    return;
                }

                if(tomato[i][j] != -1){
                    answer = Math.max(answer, tomato[i][j]);
                }
            }
        }
        System.out.println(answer - 1);
    }

    public static void bfs(){

        while(!q.isEmpty()){
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위 벗어나면 continue;
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                //토마토가 없는 칸이면 패스
                if(tomato[nx][ny] == -1)
                    continue;

                if(tomato[nx][ny] == 0){
                    tomato[nx][ny] = tomato[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
