package ProblemSolving.TreeLevelOrderTraversal;

/**
 * @author lefeverw
 */
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    static ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
    public static void levelOrder(Node root) {
        int height = height(root);
        for (int i = 0; i <= height; i++) {
            levels.add(i,new ArrayList<>());
        }
        updateList(root, 0);
if(root.left!=null)
            levelOrder(root.left,1);
        if(root.right!=null)
            levelOrder(root.right,1);
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j < levels.get(i).size(); j++) {
                System.out.print(levels.get(i).get(j)+" ");
            }
        }
    }

    private static void updateList(Node root, int level) {
        ArrayList<Integer> updatedList = levels.get(level);
        updatedList.add(root.data);
        levels.set(level,updatedList);
    }

    public static void levelOrder(Node root,int height) {
        updateList(root, height);
        if(root.left!=null)
            levelOrder(root.left,height+1);
        if(root.right!=null)
            levelOrder(root.right,height+1);

    }

    public static int height(Node root) {
        if(root.left==null && root.right==null)
            return 0;
        int rootSubTree = 0;
        if(root.left!=null)
            rootSubTree=Math.max(height(root.left),rootSubTree);
        if(root.right!=null)
            rootSubTree=Math.max(height(root.right),rootSubTree);
        return rootSubTree+1;
        // Write your code here.
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}