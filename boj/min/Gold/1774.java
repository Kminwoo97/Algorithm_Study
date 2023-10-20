import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        double answer = 0.00;

        //부모노드 초기화
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        //N개의 노드 좌표 입력
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x,y});
        }

        //이미 연결된 노드
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            //연결하기
            union(parent, x, y);
        }


        //노드 간 거리 구하기
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<n-1; i++){
            int[] pointX = list.get(i);

            for(int j=i+1; j<n; j++){
                int[] pointY = list.get(j);
                double dist = Math.sqrt(Math.pow(pointX[0] - pointY[0], 2) + Math.pow(pointX[1] - pointY[1],2));

                pq.offer(new Edge(i, j, dist));
            }
        }

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            int a = edge.a;
            int b = edge.b;

            if(find(parent, a) == find(parent, b))
                continue;

            union(parent, a, b);
            answer += edge.dist;
        }

        System.out.println(String.format("%.2f", answer));
    }

    public static void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);

        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    public static int find(int[] parent, int x){
        if(parent[x] == x)
            return x;
        return find(parent, parent[x]);
    }

}
class Edge implements Comparable<Edge>{
    int a;
    int b;
    double dist;

    public Edge(int a, int b, double dist){
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    public int compareTo(Edge o){
        if(this.dist - o.dist > 0) {
            return 1;
        }
        else if(this.dist - o.dist == 0){
            return 0;
        }else{
            return -1;
        }
    }
}
