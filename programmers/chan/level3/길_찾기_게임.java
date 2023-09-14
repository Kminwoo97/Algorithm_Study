import java.util.*;

class Solution {
    static int[] preArr;
    static int[] postArr;
    static int index = 0;
        
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        // boolean[] isVisited = new boolean[nodeinfo.length];
        preArr = new int[nodeinfo.length];
        postArr = new int[nodeinfo.length];
        Node[] tree = new Node[nodeinfo.length];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            tree[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(tree, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            }
            
            return o2.y - o1.y;
        });
        
        Node root = tree[0];
        
        for (int i = 1; i < tree.length; i++) {
            insertNode(root, tree[i]);
        }
        
        preOrder(root);
        index = 0;
        postOrder(root);
        
        answer[0] = preArr;
        answer[1] = postArr;
        
        return answer;
    }
    
    public void insertNode(Node root, Node child) {
        // x값이 root보다 작으면 왼쪽자식노드, 더 크면 오른쪽 자식노드
        if (root.x > child.x) {
            if (root.left == null) {
                root.left = child;
            } else {
                insertNode(root.left, child);
            }
        } else {
            if (root.right == null) {
                root.right = child;
            } else {
                insertNode(root.right, child);
            }
        }
    }
    
    public void preOrder(Node root) {
        preArr[index++] = root.num;
        
        if (root.left != null) {
            preOrder(root.left);
        }
        
        if (root.right != null) {
            preOrder(root.right);
        }
    }
    
    public void postOrder(Node root) {        
        if (root.left != null) {
            postOrder(root.left);
        }
        
        if (root.right != null) {
            postOrder(root.right);
        }
        
        postArr[index++] = root.num;
    }
}

class Node {
    int num;
    int x;
    int y;
    Node left; // 왼쪽 자식노드
    Node right; // 오른쪽 자식노드
    
    Node (int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
