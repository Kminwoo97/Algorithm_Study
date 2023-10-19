import java.io.*;
import java.util.*;

public class Main {

    static int n,d,k,c;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //초밥 벨트 초기화
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        //초기 max 값
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int max = map.size();
        if(!map.containsKey(c))
            max++;

        //슬라이딩 윈도우
        int rt;
        for(int lt=1; lt<n; lt++){
            rt = (lt + k - 1) % n;


            //왼쪽 삭제
            int delete = arr[lt - 1];
            map.put(delete, map.get(delete) - 1);
            if(map.get(delete) == 0)
                map.remove(delete);

            //오른쪽 삽입
            int insert = arr[rt];
            map.put(insert, map.getOrDefault(insert, 0) + 1);

            int cnt = map.size();
            if(!map.containsKey(c))
                cnt++;

            //초밥의 최대 종류 갱신
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
