import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        //6 = 5 + 1
        //6 = 4 + 2;
        //6 = 3 + 3;
        for(int i=4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            System.out.println(dp[x]);
        }

        int answer = 0;
    }
}

