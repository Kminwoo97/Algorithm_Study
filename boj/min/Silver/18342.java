import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, X;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        //N개의 도시 초기화
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        //M개의 도로 연결(a - b 연결)
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        dist = new int[N+1];
        visited = new boolean[N+1];


        //X 노드에서 갈 수 있는 최단거리 탐색
        bfs(X);

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i<dist.length; i++){
            if(dist[i] == K)
                answer.add(i);
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }

        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            x = q.poll();

            for(int i=0; i<list.get(x).size(); i++){
                int nx = list.get(x).get(i);

                if(!visited[nx]){
                    visited[nx] = true;
                    dist[nx] = dist[x] + 1;
                    q.offer(nx);
                }
            }
        }
    }
}
