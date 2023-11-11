import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());//컴퓨터 수
            int d = Integer.parseInt(st.nextToken());//의존성 수
            int c = Integer.parseInt(st.nextToken());//감연된 컴퓨터 번호

            ArrayList<ArrayList<Node>> list = new ArrayList<>();
            for(int j=0; j<=n; j++){
                list.add(new ArrayList<>());
            }

            for(int j=0; j<d; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                //b 컴퓨터가 감연되면 s초 뒤에 a 컴퓨터는 감염된다.
                list.get(b).add(new Node(s, a));
            }

            //다익스트라
            dijkstra(c, list, new boolean[n+1]);
        }
    }

    private static void dijkstra(int start, ArrayList<ArrayList<Node>> list, boolean[] visited) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, start));

        int cnt = 0;
        int answer_time = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur_index = node.index;
            int cur_time = node.time;

            //이미 방문했으면 continue
            if(visited[cur_index])
                continue;

            //방문처리하고 우선순위 큐에 삽입
            visited[cur_index] = true;
            cnt++;
            for(int i=0; i<list.get(cur_index).size(); i++){
                int next_node = list.get(cur_index).get(i).index;
                int next_time = cur_time + list.get(cur_index).get(i).time;

                pq.offer(new Node(next_time, next_node));
            }
            answer_time = cur_time;
        }

        System.out.println(cnt +" " + answer_time);
    }
}

class Node implements Comparable<Node>{
    int time;
    int index;

    public Node(int time, int index){
        this.time = time;
        this.index = index;
    }

    public int compareTo(Node o){
        return this.time - o.time;
    }

}
