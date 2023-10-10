import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            //중복되는 숫자는 numList에 넣지 않는다.
            int x = Integer.parseInt(st.nextToken());
            if(!numList.contains(x))
                numList.add(x);
        }
        Collections.sort(numList);

        dfs(0, m, new ArrayList<>());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, int m, ArrayList<Integer> list) throws IOException {
        if(list.size() == m){
            for(int i=0; i<list.size(); i++){
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=start; i<numList.size(); i++){
            list.add(numList.get(i));
            dfs(i, m, list);
            list.remove(list.size()-1);
        }
    }
}
