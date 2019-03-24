package ProblemSolving.TreeTopView;

/**
 * @author lefeverw
 */

//TODO solve

import java.util.HashMap;
import java.util.Scanner;


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
    static HashMap<Integer, int[]> covered = new HashMap<>();

    public static void topView(Node root) {
        covered.put(0, new int[]{0, root.data});
        int horizontal = 0;
        int vertical = 0;
        if (root.left != null)
            topView(root.left, horizontal - 1, vertical - 1);
        if (root.right != null)
            topView(root.right, vertical + 1, vertical - 1);
        int minValue = covered.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
        int maxValue = covered.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
        for (int i = minValue; i <= maxValue; i++) {
                System.out.print(covered.get(i)[1] + " ");
        }
    }

    private static void topView(Node root, int horizontal, int vertical) {
        if (!covered.containsKey(horizontal))
            covered.put(horizontal, new int[]{vertical, root.data});
        else {
            if (covered.get(horizontal)[0] < vertical)
                covered.put(horizontal, new int[]{vertical, root.data});
        }
        if (root.left != null)
            topView(root.left, horizontal - 1, vertical - 1);
        if (root.right != null)
            topView(root.right, horizontal + 1, vertical - 1);


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