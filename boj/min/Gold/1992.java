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
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int answer = 0;

        //부모노드 초기화
        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        //A와B를 연결하는데 dist 비용이 든다.
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(a, b, dist));
        }

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            int a = edge.a;
            int b = edge.b;

            //사이클이 형성되었다면 연결하지 않는다.
            if(find(parent, a) == find(parent, b))
                continue;

            //연결한다.
            union(parent, a,b);
            answer += edge.dist;
        }

        System.out.println(answer);
    }

    public static void union(int[] parent, int a, int b) {
        //부모를 찾는다.
        a = find(parent, a);
        b = find(parent, b);

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static int find(int[] parent, int target){
        if(parent[target] == target)
            return target;
        return find(parent, parent[target]);
    }


}
class Edge implements Comparable<Edge>{
    int a;
    int b;
    int dist;

    public Edge(int a, int b, int dist){
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    public int compareTo(Edge o){
        return this.dist - o.dist;
    }
}
