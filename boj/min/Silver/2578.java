import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[5][5];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<5; j++){
                int n = Integer.parseInt(st.nextToken());
                answer++;


                for(int k=0; k<5; k++){
                    for(int l=0; l<5; l++){
                        if(map[k][l] == n){
                            map[k][l] = 0;

                            //row, col,l_diagonal, r_diagonal
                            int cnt = 0;
                            cnt += check_row(map);
                            cnt += check_col(map);
                            cnt += check_l_diagonal(map);
                            cnt += check_r_diagonal(map);

                            if(cnt >=3){
                                System.out.println(answer);
                                return;
                            }
                        }
                    }
                }
            }
        }

    }

    public static int check_row(int[][] map){
        int cnt = 0;

        for(int i=0; i<5; i++){
            boolean flag = true;

            for(int j=0; j<5; j++){
                if(map[i][j] != 0){
                    flag = false;
                    break;
                }
            }

            if(flag)
                cnt++;
        }
        return cnt;
    }
    public static int check_col(int[][] map){
        int cnt = 0;

        for(int i=0; i<5; i++){
            boolean flag = true;

            for(int j=0; j<5; j++){
                if(map[j][i] != 0){
                    flag = false;
                    break;
                }
            }

            if(flag)
                cnt++;
        }
        return cnt;
    }

    public static int check_l_diagonal(int[][] map) {
        int cnt = 0;

        boolean flag = true;
        for (int i=0; i<5; i++) {
            if(map[i][i] != 0){
                flag = false;
                break;
            }
        }

        if(flag)
            cnt++;

        return cnt;
    }
    public static int check_r_diagonal(int[][] map){
        int cnt = 0;

        boolean flag = true;
        for (int i=0; i<5; i++) {
            if(map[i][5-i-1] != 0){
                flag = false;
                break;
            }
        }

        if(flag)
            cnt++;

        return cnt;
    }

}
