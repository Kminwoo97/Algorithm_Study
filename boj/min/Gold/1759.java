import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<String> list = new ArrayList<>();

    static int L,C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<C; i++){
            list.add(st.nextToken());
        }
        Collections.sort(list);

        dfs(0, new StringBuilder());
    }

    public static void dfs(int start, StringBuilder sb){
        if(sb.length() == L){
            //모음과 모음이 아닌거 카운팅
            int aeiou = 0;
            int other = 0;
            for(int i=0; i<sb.length(); i++){
                if(sb.substring(i, i+1).equals("a") || sb.substring(i, i+1).equals("e") || sb.substring(i, i+1).equals("i")
                            || sb.substring(i, i+1).equals("o") || sb.substring(i, i+1).equals("u")){
                    aeiou++;
                }else{
                    other++;
                }
            }

            if(aeiou >= 1 && other >= 2)
                System.out.println(sb.toString());
            return;
        }

        for(int i=start; i<C; i++){
            sb.append(list.get(i));
            dfs(i+1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
