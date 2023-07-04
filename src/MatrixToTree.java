import java.util.*;


public class MatrixToTree {
    public static Map<Integer, List<Integer>> transformToTree(List<List<Integer>> matrix) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        for (int i = 0; i < rows; i++) {
            adjacencyList.put(i, new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i).get(j) == 1)
                    adjacencyList.get(i).add(j);
            }
        }


        return adjacencyList;
    }

    public static int maxRegion(List<List<Integer>> grid) {

        Map<Integer, List<Integer>> adjacencyList = transformToTree(grid);

        int regionSize = 0;

        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {

            for(Integer i : entry.getValue()) {

            }
        }

        return regionSize;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 1, 0, 0),
                Arrays.asList(0, 1, 1, 0),
                Arrays.asList(0, 0, 1, 0),
                Arrays.asList(1, 0, 0, 0)
        );

        List<List<Integer>> matrix2 = Arrays.asList(
                Arrays.asList(0, 0, 0, 0, 0, 1),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0)
        );


        Map<Integer, List<Integer>> tree = transformToTree(matrix);

        // Print the adjacency list representation of the tree
        for (Map.Entry<Integer, List<Integer>> entry : tree.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
    }
}

