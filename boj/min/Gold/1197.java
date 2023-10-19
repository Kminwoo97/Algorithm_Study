import java.io.*;
import java.util.*;

public class Main {

    static int n,e;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        //부모집합 초기화
        parent = new int[n+1];
        for(int i=0; i<=n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> list = new ArrayList<Edge>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(a,b,cost));
        }
        Collections.sort(list);

        long value = 0;
        for(int i=0; i<list.size(); i++){
            Edge edge = list.get(i);
            int a = edge.a;
            int b = edge.b;

            //사이클이 형성된다면 연결하지 않는다.
            if(find(a) == find(b))
                continue;

            //연결하고 가중치 더한다.
            union(a,b);
            value += edge.cost;
        }

        System.out.println(value);
    }

    public static int find(int x){
        if(parent[x] == x)
            return x;
        return find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b){
            parent[b] = a;
        }else {
            parent[a] = b;
        }
    }
}
class Edge implements Comparable<Edge>{
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    //간선의 가중치를 기준으로 오름차순 정렬
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
