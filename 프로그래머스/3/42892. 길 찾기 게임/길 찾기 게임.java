import java.util.*;

class Solution {
    static class TreeNode {
        private int n;
        private int x;
        private int y;
        private TreeNode leftTree;
        private TreeNode rightTree;
        
        public TreeNode(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
    
    private static TreeNode[] nodes;
    private static ArrayList<Integer> preOrderList = new ArrayList<>();
    private static ArrayList<Integer> postOrderList  = new ArrayList<>();
    
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        int N = nodeinfo.length;
        nodes = new TreeNode[N];
                
        for (int i = 0; i < N; i++) {
            nodes[i] = new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) { 
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });
        
        TreeNode root = nodes[0];
        for (int i = 1; i < N; i++) {
            makeTree(root, nodes[i]);            
        }
        preOrder(root);
        postOrder(root);
        
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
    

    private static void makeTree(TreeNode treeNode, TreeNode node) {
        
        if (treeNode.x < node.x) {
            if (treeNode.rightTree == null) {
                treeNode.rightTree = node;
                return;
            }
            makeTree(treeNode.rightTree, node);
        } else {
            if (treeNode.leftTree == null) {
                treeNode.leftTree = node;
                return;
            }
            makeTree(treeNode.leftTree, node);
        }
    }
    
    private static void preOrder(TreeNode node) {
        if (node == null) return;
        preOrderList.add(node.n);
        preOrder(node.leftTree);
        preOrder(node.rightTree);
    }
    
    private static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.leftTree);
        postOrder(node.rightTree);
        postOrderList.add(node.n);
    }
}