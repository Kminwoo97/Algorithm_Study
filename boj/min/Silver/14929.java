import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        long x = 0L;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            x += arr[i];
        }
        x -= arr[0];

        //arr[0]*arr[1] + arr[0]*arr[2] + ... + arr[1]*arr[2] + arr[1]*arr[3]
        //-> arr[0](arr[1] + arr[2] + ... arr[1](arr[2] + arr[3] + ...) + ....
        long answer = 0;
        for(int i=1; i<n; i++){
            answer += x * arr[i-1];
            x -= arr[i];
        }
        System.out.println(answer);
    }
}
