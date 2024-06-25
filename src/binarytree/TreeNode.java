package binarytree;

public class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.value = val;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode createTreeFromArray(int[] arr) {
        return createTreeFromArray(arr, 0);
    }

    private TreeNode createTreeFromArray(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = createTreeFromArray(arr, 2 * index + 1);
        root.right = createTreeFromArray(arr, 2 * index + 2);
        return root;
    }
}
