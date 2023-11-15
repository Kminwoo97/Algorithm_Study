import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //로테이션을 돌려야하는 사각형 수 -> Math.min(n,m) / 2
        int cnt = Math.min(n, m) / 2;
        for(int i=0; i<r; i++){
            for(int j=0; j<cnt; j++){

                //로테이션 돌려야하는 사각형의 왼쪽 최상단 값
                int tmp = arr[j][j];

                //오른쪽->왼쪽(x값 고정, y값 이동)
                for (int k = j; k < m - 1 - j; k++) {
                    arr[j][k] = arr[j][k + 1];
                }


                //아래->위(x값 이동, y값 고정)
                for (int k = j; k < n - 1 - j; k++) {
                    arr[k][m - 1 - j] = arr[k + 1][m - 1 - j];
                }

                //왼쪽->오른쪽(x값 고정, y값 이동)
                for (int k = m - 1 - j; k > j; k--) {
                    arr[n - 1 - j][k] = arr[n - 1 - j][k - 1];
                }

                //위->아래(x값 이동, y값 고정)
                for (int k = n - 1 - j; k > j; k--) {
                    arr[k][j] = arr[k - 1][j];
                }

                arr[j+1][j] = tmp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
