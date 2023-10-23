import java.io.*;
import java.util.*;

public class Main {

    static char[] quack = new char[]{'q','u','a','c','k'};
    static boolean[] checked;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine();
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<x.length(); i++){
            list.add(x.charAt(i));
        }

        int answer = 0;

        int idx = 0;
        while(true){
            int cnt = 0;
            for(int i=0; i<list.size(); i++){
                if(list.get(i) == quack[idx]){
                    list.remove(i);
                    i--;
                    idx++;

                    if(idx == 5) {
                        idx = 0;
                        cnt++;
                    }
                }
            }


            //문자열을 모두 순회했을때, idx의 값이 0이고 찾은 quack의 수가 0 이상이면 오리를 찾은 것이다.
            if(cnt > 0 && idx == 0){
                answer++;
            }else{
                answer = -1;
                break;
            }

            //모든 오리를 다 찾았으면 탈출한다.
            if(list.isEmpty()){
                break;
            }
        }

        System.out.println(answer);
    }
}

