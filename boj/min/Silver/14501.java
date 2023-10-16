import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+5]; //상담이 최대 5일간 진행되므로 5만큼 크기를 늘려준다.
        for(int i=n-1; i>=0; i--){
            if(i + t[i] <= n){
                //상담이 가능한 경우
                dp[i] = Math.max(dp[i + t[i]] + p[i], dp[i+1]);
            }else{
                //상담이 불가능한 경우 -> 이전의 값을 가져온다.
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[0]);
    }
}
