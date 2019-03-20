package ProblemSolving.TreeTopView;

/**
 * @author lefeverw
 */

//TODO solve
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
    public static void topView(Node root) {
        if (root.left != null)
            topView(root.left, 0);
        System.out.print(root.data + " ");
        if (root.right != null)
            topView(root.right, 1);

    }

    private static void topView(Node root, int i) {
        if (i == 0) {
            if (root.left != null)
                topView(root.left, 0);
            System.out.print(root.data + " ");
//            if (root.left == null && root.right != null)
//                topView(root.right, 1);
        }else{
//            if(root.right==null && root.left !=null)
//                topView(root.left, 0);
            System.out.print(root.data + " ");
            if (root.right != null)
                topView(root.right, 1);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
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
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}