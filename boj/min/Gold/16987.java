import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Egg[] eggList;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //초기화 작업
        n = Integer.parseInt(br.readLine());
        eggList = new Egg[n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int durability = Integer.parseInt(st.nextToken());
            int kg = Integer.parseInt(st.nextToken());

            eggList[i] = new Egg(durability, kg);
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int x){

        //마지막 계란까지 들어서 모두 부딪혔다면 종료한다.
        if(x == n){
            int cnt = 0;
            for(int i=0; i<n; i++){
                if(eggList[i].durability <= 0)
                    cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }

        //들고있는 계란이 깨진 계란이면 다음 계란을 집는다.
        if(eggList[x].durability <= 0){
            dfs(x+1);
        }else{
            boolean isBroken = false;
            for(int i=0; i<n; i++){
                //들고있는 계란과 부딪힐 계란이 같은거면 continue
                if(x == i)
                    continue;

                //부딪힐 계란이 깨진 계란이라면 continue
                if(eggList[i].durability <= 0)
                    continue;

                isBroken = true;
                eggList[x].durability -= eggList[i].kg;
                eggList[i].durability -= eggList[x].kg;

                dfs(x+1);

                eggList[x].durability += eggList[i].kg;
                eggList[i].durability += eggList[x].kg;
            }
            //부딪히지 않았다면 다음 계란을 집는다.
            if(!isBroken){
                dfs(x+1);
            }
        }
    }
}

class Egg{
    int durability;
    int kg;

    public Egg(int durability, int kg){
        this.durability = durability;
        this.kg = kg;
    }
}
