import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //mCn = m-1Cn-1 + m-1Cn
        //nC0 = 1, nCn = 1
        dp = new int[31][31];
        for(int i=0; i<=30; i++){
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        for(int i=2; i<=30; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            System.out.println(dp[m][n]);
        }
    }
}
