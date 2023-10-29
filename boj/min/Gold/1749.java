import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //가로(열), 세로(행) 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //배열 초기화
        int[][] arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //i행j열 까지 누적합 구하기
        int[][] cumulative_sum = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                cumulative_sum[i][j] = arr[i][j] + cumulative_sum[i-1][j] + cumulative_sum[i][j-1] - cumulative_sum[i-1][j-1];
            }
        }

        //정답 도출하기
        int answer = Integer.MIN_VALUE;
        for (int r2 = 1; r2 <= n; r2++) {
            for (int c2 = 1; c2 <= m; c2++) {

                for (int r1 = 1; r1 <= r2; r1++) {
                    for (int c1 = 1; c1 <= c2; c1++) {
                        answer = Math.max(answer, cumulative_sum[r2][c2] - cumulative_sum[r1 - 1][c2] - cumulative_sum[r2][c1 - 1] + cumulative_sum[r1 - 1][c1 - 1]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
