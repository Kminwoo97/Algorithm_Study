import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        //배열 초기화
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(arr);
        
        //모든 숫자가 0인 경우 nC3 = 10000 * 9999 * 9998 / 3 이 int의 범위를 벗어난다.
        long answer = 0;
        
        for(int i=0; i<n; i++){
            //첫 숫자가 0보다 크면 3개의 합이 0이 절대 안나온다.
            if(arr[i] > 0)
                break;

            //left, right 초기 설정
            int lt = i + 1;
            int rt = n - 1;

            while(lt < rt){
                int sum = arr[i] + arr[lt] + arr[rt];

                if(sum == 0) {
                    int cntA = 1;
                    int cntB = 1;

                    //lt ~ rt 구간이 모두 같은 경우이다. 구간에서 2개를 뽑으면 된다. nC2
                    if (arr[lt] == arr[rt]) {
                        answer += (rt - lt + 1) * (rt - lt) / 2;
                        break;
                    }

                    //좌측에서 같은 숫자 갯수 카운팅
                    while (lt + 1 < rt && arr[lt] == arr[lt + 1]) {
                        lt++;
                        cntA++;
                    }

                    //우측에서 같은 숫자 갯수 카운팅
                    while (rt - 1 > lt && arr[rt] == arr[rt - 1]) {
                        rt--;
                        cntB++;
                    }

                    answer += (cntA * cntB);
                }

                if(sum > 0){
                    rt--;
                }else{
                    lt++;
                }
            }
        }

        System.out.println(answer);
    }
}
