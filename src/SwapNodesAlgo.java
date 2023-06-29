import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwapNodesAlgo {

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        Node root = buildTree(indexes);
        for (int k : queries) {
            swapSubtrees(root, k, 1);
            List<Integer> traversal = inOrderTraversal(root);
            result.add(traversal);
        }
        return result;
    }

    private static Node buildTree(List<List<Integer>> indexes) {
        Node[] nodes = new Node[indexes.size() + 1];
        nodes[1] = new Node(1);
        for (int i = 0; i < indexes.size(); i++) {
            int left = indexes.get(i).get(0);
            int right = indexes.get(i).get(1);
            Node node = nodes[i + 1];
            if (left != -1) {
                node.left = new Node(left);
                nodes[left] = node.left;
            }
            if (right != -1) {
                node.right = new Node(right);
                nodes[right] = node.right;
            }
        }
        return nodes[1];
    }

    private static List<Integer> inOrderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = node;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.data);
            curr = curr.right;
        }
        return result;
    }

    private static void swapSubtrees(Node node, int k, int depth) {
        if (node == null) {
            return;
        }
        if (depth % k == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swapSubtrees(node.left, k, depth + 1);
        swapSubtrees(node.right, k, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/swapNodes1.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        List<List<Integer>> result = SwapNodesAlgo.swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" ")))
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                        System.out.print(e);
                });

        bufferedReader.close();

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

