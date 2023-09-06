import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.offer(new Node(i, priorities[i]));
        }
        
        int cnt = 1;
        while(!q.isEmpty()){
            Node curNode = q.poll();
            
            boolean flag = true;
            for(int i=0; i<q.size(); i++){
                if(curNode.val < q.peek().val){
                    flag = false;
                }
                q.offer(q.poll());
            }
            
            if(flag){
                if(location == curNode.idx){
                    answer = cnt;
                    break;
                }
                cnt++;
            }
            else{
                q.offer(curNode);
            }
        }
        
        return answer;
    }
}
class Node{
    int idx;
    int val;
    
    public Node(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}
