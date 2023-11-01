import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n,k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        for(int rt=0; rt<n; rt++){
            while(lt < rt && map.getOrDefault(arr[rt], 0) >= k){
                map.put(arr[lt], map.getOrDefault(arr[lt], 0) - 1);
                lt++;
            }

            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);
    }
}
