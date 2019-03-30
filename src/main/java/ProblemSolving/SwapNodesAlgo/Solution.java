package ProblemSolving.SwapNodesAlgo;

/**
 * @author lefeverw
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Node {
    Node left;
    Node right;
    int data;
    int depth;
    int width;

    Node(int data, int depth, int width) {
        this.data = data;
        left = null;
        right = null;
        this.depth = depth;
        this.width = width;
    }
}

public class Solution {


    /*
     * Complete the swapNodes function below.
     */
    static ArrayList<Integer> temporary = new ArrayList<>();
    static HashMap<Integer, ArrayList<Node>> treeMap = new HashMap<>();

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        //build tree and store nodes in map so that parent can easily be fetched
        Node root = buildTree(indexes);
        int[][] swapped = new int[queries.length][];

        //perform necessary swaps
        final int[] counter = {0};
        Arrays.stream(queries).forEach(levelOfTree -> {
            performSwaps(levelOfTree);
            temporary = new ArrayList<>();
            inOrder(root);
            swapped[counter[0]] = storeInOrderValues();
            counter[0]++;

        });
        return swapped;
    }

    private static int[] storeInOrderValues() {
        return temporary.stream().filter(x -> x != -1).mapToInt(i -> i).toArray();
    }

    private static void performSwaps(int levelOfTree) {
        int multiple = levelOfTree;
        while (treeMap.containsKey(multiple - 1)) {
            ArrayList<Node> possibleParents = (ArrayList<Node>) treeMap.get(multiple-1).stream().filter(node -> node.data != -1).collect(Collectors.toList());
            possibleParents.stream().forEach(parent -> {
                Node temp = parent.left;
                parent.left = parent.right;
                parent.right = temp;
            });
            multiple+=levelOfTree;
        }
    }

    private static Node buildTree(int[][] indexes) {
        Node root = new Node(1, 0, 0);
        treeMap.computeIfAbsent(0, nodes -> new ArrayList<>()).add(root);
        final int[] level = {1};
        AtomicInteger numberOfChildWithinLevel = new AtomicInteger();
        IntStream.range(0, indexes.length).forEach(index -> {
            Node leftChild = new Node(indexes[index][0], 0, 0);
            Node rightChild = new Node(indexes[index][1], 0, 0);
            treeMap.computeIfAbsent(level[0], nodes -> new ArrayList<>()).add(leftChild);
            treeMap.computeIfAbsent(level[0], nodes -> new ArrayList<>()).add(rightChild);
            ArrayList<Node> possibleParents = (ArrayList<Node>) treeMap.get(level[0] - 1).stream().filter(node -> node.data != -1).collect(Collectors.toList());
            Node parent = possibleParents.get(numberOfChildWithinLevel.get());
            parent.left = leftChild;
            parent.right = rightChild;
            numberOfChildWithinLevel.getAndIncrement();
            if (possibleParents.size() == numberOfChildWithinLevel.get()) {
                numberOfChildWithinLevel.set(0);
                level[0]++;
            }
        });
        return root;
    }

    public static void inOrder(Node root) {
        if (root.left == null && root.right == null) {
            temporary.add(root.data);
            return;
        }
        if (root.left != null)
            inOrder(root.left);
        temporary.add(root.data);
        if (root.right != null)
            inOrder(root.right);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

