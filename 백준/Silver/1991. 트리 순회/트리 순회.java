import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        TreeNode rootNode = new TreeNode(st.nextToken());
        Tree tree = new Tree(rootNode);
        rootNode.setLeftNode(st.nextToken());
        rootNode.setRightNode(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            TreeNode findTreeNode = findNode(tree.getRoot(), st.nextToken());
            findTreeNode.setLeftNode(st.nextToken());
            findTreeNode.setRightNode(st.nextToken());
        }
        
        preOrder(rootNode);
        System.out.println();
        inOrder(rootNode);
        System.out.println();
        postOrder(rootNode);
    }
    
    // 노드 찾기 
    private static TreeNode findNode(TreeNode node, String alphabet) {
        if (node == null) {
            return null;
        }
    
        if (alphabet.equals(node.getAlphabet())) {
            return node;
        }
        
        findNode(node.getLeftNode(), alphabet);
        findNode(node.getRightNode(), alphabet);
           
        TreeNode leftResult = findNode(node.getLeftNode(), alphabet);
        if (leftResult != null) {
           return leftResult; // 왼쪽에서 찾으면 반환
        }
        return findNode(node.getRightNode(), alphabet); // 오른쪽 결과 반환
    }
    
    // 전위순회
    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getAlphabet());
        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }
    
    private static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftNode());
        System.out.print(node.getAlphabet());
        inOrder(node.getRightNode());
    }
    
    private static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeftNode());
        postOrder(node.getRightNode());
        System.out.print(node.getAlphabet());
    }    
}

class Tree {
    private TreeNode root;
    
    public Tree(TreeNode root) {
         this.root = root;
    }
    
    public TreeNode getRoot() {
        return this.root;
    }
}

class TreeNode {
    private String alphabet;
    private TreeNode leftNode;
    private TreeNode rightNode;
    
    public TreeNode(String alphabet) {
        this.alphabet = alphabet;       
    }
    
    public void setLeftNode(String leftStr) {   
       if (!leftStr.equals(".")) {
           this.leftNode = new TreeNode(leftStr);
       }        
    }
    
    public void setRightNode(String rightStr) {
       if (!rightStr.equals(".")) {
           this.rightNode = new TreeNode(rightStr);
       }   
    }
    
    public TreeNode getLeftNode() {
        return this.leftNode;
    }
    
    public TreeNode getRightNode() {
        return this.rightNode;
    }   
    
    public String getAlphabet() {
        return this.alphabet;
    }      
}