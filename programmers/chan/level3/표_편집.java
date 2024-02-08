import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Node> stack = new Stack<>();
        Node[] nodes = new Node[n];
        int cur = k;
        
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i - 1, i, i + 1);
        }
        
        nodes[n - 1].next = -1;
        
        for (int i = 0; i < cmd.length; i++) {
            String[] splitedCmd = cmd[i].split(" ");
            String oper = splitedCmd[0];
            
            switch (oper) {
                case "D":
                    int x = Integer.parseInt(splitedCmd[1]);
                    
                    while (x > 0) {
                        cur = nodes[cur].next;
                        x--;
                    }
                    
                    break;
                case "U":
                    x = Integer.parseInt(splitedCmd[1]);
                    
                    while (x > 0) {
                        cur = nodes[cur].pre;
                        x--;
                    }
                    
                    break;
                case "C":
                    int preNode = nodes[cur].pre;
                    int nextNode = nodes[cur].next;
                    
                    if (preNode != -1) {
                        nodes[preNode].next = nodes[cur].next;
                    }
                    
                    if (nextNode != -1) {
                        nodes[nextNode].pre = nodes[cur].pre;
                    }
                    
                    stack.push(nodes[cur]);
                    
                    if (nextNode == -1) {
                        cur = preNode;
                    } else {
                        cur = nextNode;
                    }
                    
                    break;
                case "Z":
                    Node pre = stack.pop();
                    
                    preNode = nodes[pre.cur].pre;
                    nextNode = nodes[pre.cur].next;
                    
                    if (preNode != -1) {
                        nodes[preNode].next = pre.cur;
                    }
                    
                    if (nextNode != -1) {
                        nodes[nextNode].pre = pre.cur;
                    }
                    
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("O".repeat(n));
                          
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            sb.setCharAt(node.cur, 'X');
        }
        
        return answer = sb.toString();
    }   
}

class Node {
    int pre;
    int cur;
    int next;
    
    public Node(int pre, int cur, int next) {
        this.pre = pre;
        this.cur = cur;
        this.next = next;
    }
}
