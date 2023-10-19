import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dfs(N, K);
    }

    public static void dfs(int cur, int target){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(cur, 0));
        visited[cur] = true;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int x = node.index;
            int time = node.time;

            if(x == target){
                System.out.println(time);
                return;
            }

            //visited 위치가 중요하다. pq에서 꺼냈을 때, 방문처리 해야한다.
            visited[x] = true;

            
            if(x+1 <= 100000 && !visited[x+1]){
                pq.offer(new Node(x+1, time+1));
            }
            if(x * 2 <= 100000 && !visited[x*2]){
                pq.offer(new Node(x*2, time));
            }
            if(x-1 >= 0 && !visited[x-1]){
                pq.offer(new Node(x-1, time+1));
            }
        }
    }
}

class Node implements Comparable<Node>{
    int index;
    int time;

    public Node(int index, int time){
        this.index = index;
        this.time = time;
    }

    //시간을 기준으로 오름차순 정렬
    public int compareTo(Node o){
        return this.time - o.time;
    }
}
