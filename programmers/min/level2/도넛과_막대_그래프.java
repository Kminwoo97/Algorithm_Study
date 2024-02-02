import java.util.*;
class Solution {
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        //그래프 초기화 및 연결
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            int max = Math.max(a, b);
            while(graph.size() < max + 1){
                graph.add(new ArrayList<>());
            }
            
            graph.get(a).add(b);
        }
        
        int n = graph.size() - 1;
        
        //새로 생선한 노드(중심 노드) 찾기
        int[][] counting = new int[n+1][2];
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            counting[a][0]++; //X로부터 뻗어나가는것
            counting[b][1]++; //X로 들어오는 간선   
        }
        
        
        //중심노드 찾기
        int root_node = -1;
        for(int i=1; i<=n; i++){
            if(counting[i][0] >= 2 && counting[i][1] == 0){
                root_node = i;
                break;
            }
        }
        answer[0] = root_node;
        
        //중심노드와 연결 그래프 탐색
        ArrayList<Integer> start_nodes = graph.get(root_node);
        for(int i=0; i<start_nodes.size(); i++){
            int start_node = start_nodes.get(i);
            
            int idx = bfs(graph, start_node);
            answer[idx]++;
        }
        
        return answer;
    }
    
    
    public int bfs(ArrayList<ArrayList<Integer>> graph, int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int a = q.poll();
            
            //8자 그래프(특정 노드에서 연결점이 2개인 경우)
            if(graph.get(a).size() == 2)
                return 3;
            
            //막대 그래프(끝 지점이 연결이 끊겼다)
            if(graph.get(a).size() == 0)
                return 2;
            
            //도넛 그래프(시작 지점과 끝 지점이 같은 경우)
            if(start == graph.get(a).get(0))
                return 1;
            
            q.offer(graph.get(a).get(0));
        }
        
        return -1;
    }
}
