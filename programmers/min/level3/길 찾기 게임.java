import java.util.*;

class Solution {
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer;
        
        int n = nodeinfo.length;
        int[][] nodes = new int[n][3];
        
        for(int i=0; i<n; i++){
            nodes[i][0] = i + 1;
            nodes[i][1] = nodeinfo[i][0];
            nodes[i][2] = nodeinfo[i][1];
        }
        Arrays.sort(nodes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(b[2] == a[2])
                    return a[1] - b[1];
                return b[2] - a[2];
            }
        });
            
        BinaryTree bt = new BinaryTree();
        for(int i=0; i<n; i++){
            int idx = nodes[i][0];
            int x = nodes[i][1];
            int y = nodes[i][2];
            bt.add(new Node(idx, x, y));
        }
        
        //전위순회, 후위 순회
        answer = new int[2][n];
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        bt.SearchPreOrder(bt.root, preOrder);
        bt.SearchPostOrder(bt.root, postOrder);
        for(int i=0; i<n; i++){
            answer[0][i] = preOrder.get(i);
        }
        for(int i=0; i<n; i++){
            answer[1][i] = postOrder.get(i);
        }
        
        return answer;
    }
}

class Node{
    Node left;
    Node right;
    int i;
    int x;
    int y;
    
    public Node(int i, int x, int y){
        this.i = i;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    Node root;
    
    public BinaryTree(){
        this.root = null;
    }
    
    public void add(Node newNode){
        
        if(root == null){
            root = newNode;
        }else{
            addNode(root, newNode);
        }
    }
    
    public Node addNode(Node parent, Node child){
        if(parent == null)
            return child;
        
        if(parent.x > child.x){
            parent.left = addNode(parent.left, child);
        }else{
            parent.right = addNode(parent.right, child);
        }
        
        return parent;
    }
    
    //전위순회
    public void SearchPreOrder(Node node, ArrayList<Integer> preOrder){
        if(node == null)
            return;
        preOrder.add(node.i);
        SearchPreOrder(node.left, preOrder);
        SearchPreOrder(node.right, preOrder);
    }
    
    //후위순회
    public void SearchPostOrder(Node node, ArrayList<Integer> postOrder){
        if(node == null)
            return;
        SearchPostOrder(node.left, postOrder);
        SearchPostOrder(node.right, postOrder);
        postOrder.add(node.i);
    }
}
