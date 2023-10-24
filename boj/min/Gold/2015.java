import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        long answer = 0;

        //누적합 기록한다.
        long[] arr = new long[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());

            //누적합의 결과가 K 라면 카운팅
            if(arr[i] == k)
                answer++;
        }
        
        
        //HashMap 카운팅으로 정답도출
        HashMap<Long, Long> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            //arr[i]-K의 값이 Map에 존재한다는 것은 i까지의 누적합에서 arr[i]-k의 값을 빼면 K를 만들 수 있다.
            //따라서 arr[i]-K의 개수는 현재 누적합에서 K를 만들 수 있는 경우의 수를 의미한다.
            if(map.containsKey(arr[i] - k))
                answer += map.get(arr[i] - k);
            
            //누적합을 map에 기록한다.
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1L);
        }

        System.out.println(answer);
    }
}
