import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for(int rt=0; rt<n; rt++){
            sum += arr[rt];
            while(lt < rt && sum >= s){
                answer = Math.min(answer, rt - lt + 1);
                sum -= arr[lt];
                lt++;
            }
            
            if(sum >= s){
                answer = Math.min(answer, rt - lt + 1);
            }
        }

        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        System.out.println(answer);

    }
}
