import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        //간선을 기준으로 오르차순 정렬
        ArrayList<Edge> edgeList = new ArrayList<>();
        for(int[] cost : costs){
            edgeList.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edgeList);
        
        //집합 - 서로소 집합인지 확인하려고
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        //크루스칼 알고리즘
        for(Edge edge : edgeList){
            int x = edge.x;
            int y = edge.y;
            
            //서로 같은 집합에 속하는지 Find 하고 Union(Union Find)
            if(find(parent, x) == find(parent, y))
                continue;
            union(parent, x, y);
            
            answer += edge.cost;
        }
        
        return answer;
    }
    
    public int find(int[] parent, int target){
        if(parent[target] == target)
            return target;
        else
            return find(parent, parent[target]);   
    }
    
    public void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);
        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }
}

class Edge implements Comparable<Edge>{
    int x;
    int y;
    int cost;
    
    public Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}
