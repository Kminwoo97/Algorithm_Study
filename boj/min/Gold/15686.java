import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m,cnt;
    static int answer = Integer.MAX_VALUE;

    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                int x = Integer.parseInt(st.nextToken());

                if(x == 1)
                    home.add(new int[]{i,j});
                else if(x == 2)
                    chicken.add(new int[]{i, j});
            }
        }

        cnt = chicken.size();

        dfs(0, new ArrayList<>());
        System.out.println(answer);
    }

    public static void dfs(int n, ArrayList<int[]> c_list){
        if(n == cnt){
            //M개의 치킨집 골랐을 경우
            if(c_list.size() == m){
                //집과 치킨집의 최소거리 계산
                answer = Math.min(answer, calc(c_list));
            }
            return;
        }

        //치킨집 유지
        c_list.add(chicken.get(n));
        dfs(n+1, c_list);
        c_list.remove(c_list.size() - 1);

        //치킨집 폐업
        dfs(n+1, c_list);
    }

    private static int calc(ArrayList<int[]> c_list) {
        int result = 0;

        for(int i=0; i<home.size(); i++) {
            int x = home.get(i)[0];
            int y = home.get(i)[1];
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < c_list.size(); j++) {
                int nx = c_list.get(j)[0];
                int ny = c_list.get(j)[1];

                tmp = Math.min(tmp, Math.abs(nx - x) + Math.abs(ny - y));
            }

            result += tmp;
        }
        return result;
    }

}
