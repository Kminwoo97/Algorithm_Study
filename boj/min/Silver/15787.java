import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        //기차 수, 명령어 수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trains = new int[n+1];

        for(int j=0; j<m; j++){
            st = new StringTokenizer(br.readLine(), " ");

            //명령어 종류, i 번째 기차
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if(command == 1){
                //승차
                int x = Integer.parseInt(st.nextToken());
                if((trains[i] & (0x1 << (x-1))) != (int)Math.pow(2, x-1)){
                    trains[i] += (0x1 << (x-1));
                }
            }else if(command == 2){
                //하차
                int x = Integer.parseInt(st.nextToken());
                if((trains[i] & (0x1 << (x-1))) == (int)Math.pow(2, x-1)){
                    trains[i] -= (0x1 << (x-1));
                }
            }
            else if(command == 3){
                //k = k + 1 이동 ( << )
                trains[i] = trains[i] << 1;
                if(trains[i] >= (int)Math.pow(2, 20))
                    trains[i] -= (int)Math.pow(2, 20);

            }else if(command == 4){
                //k = k - 1 이동 ( >> )
                trains[i] = trains[i] >> 1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            if(!map.containsKey(trains[i]))
                map.put(trains[i], 1);
        }

        System.out.println(map.size());
    }

}
