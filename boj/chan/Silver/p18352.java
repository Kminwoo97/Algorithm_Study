import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new List[n + 1];
        distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[x] = 0;

        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        bfs(adj, x);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == k) {
                sb.append(i + "\n");
            }
        }

        if (sb.length() != 0) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs(List<Integer>[] adj, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < adj[cur].size(); i++) {
                int next = adj[cur].get(i);

                if (distance[next] > distance[cur] + 1) {
                    distance[next] = distance[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
