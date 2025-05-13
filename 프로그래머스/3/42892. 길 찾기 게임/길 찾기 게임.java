import java.util.*;

class Solution {
    
    static class Node {
        private int n;
        private int x;
        private int y;
        
        private Node left;
        private Node right;
        
        public Node(int n, int x, int y) {
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }
    
    Node[] nodes;
    int maxHeight;
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        makeNode(nodeinfo);       
        Node root = nodes[0];
        
        for (int i = 1; i < nodes.length; i++) {
           makeTree(root, nodes[i]);
        } 
        
        int[][] answer = new int[2][nodes.length];
        preOrder(root);
        postOrder(root);
        
        for (int i = 0; i < pre.size(); i++) {
            answer[0][i] = pre.get(i);
        }
        
        for (int i = 0; i < post.size(); i++) {
            answer[1][i] = post.get(i);
        }
        
        return answer;
    }
    
    private void preOrder(Node node) {
        if (node == null) return;
        pre.add(node.n);
        preOrder(node.left);
        preOrder(node.right);
    }
  
    private void postOrder(Node node) {  
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right); 
        post.add(node.n);
    }
    
    void makeNode(int[][] nodeinfo) {
        nodes = new Node[nodeinfo.length];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
         Arrays.sort(nodes, (a, b) -> {
            if (b.y == a.y) {
                return b.x - a.x;
            }
            return b.y - a.y;
            
        });
    
    }
    
    private void makeTree(Node tree, Node n) {
        if (tree.x < n.x) {
            if (tree.right == null) {
                tree.right = n;
                return;
            }
            makeTree(tree.right, n);
        } else {
            if (tree.left == null) {
                tree.left = n;
                return;
            }
            makeTree(tree.left, n);
        }
    }
}