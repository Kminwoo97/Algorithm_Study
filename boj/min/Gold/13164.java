import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //초기화 및 정렬
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //인접한 유치원생의 키 차이를 기록하고 정렬한다.
        int[] dif = new int[n-1];
        for(int i=0; i<dif.length; i++){
            dif[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(dif);

        int answer = 0;
        //1. k개의 그룹으로 나누기 위해서 k-1 번의 선을 그어서 그룹을 분리해야한다.
        //2. 그룹을 분리하기 위해서 선을 그으면 그 부분에서 드는 티셔츠 만드는 비용을 제외할 수 있다.
        //위의 성질을 이용해서 오름차순으로 정렬된 dif 배열에서 뒤에서 k-1개를 제외한 나머지를 더하면 된다.
        for(int i=0; i<dif.length-(k-1); i++){
            answer += dif[i];
        }

        System.out.println(answer);
    }
}
