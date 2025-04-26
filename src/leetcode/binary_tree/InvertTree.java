package leetcode.binary_tree;

public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return root;

        TreeNode aux = root.left;
        root.left = root.right;
        root.right = aux;

        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t11 = new TreeNode(22);
        TreeNode t22 = new TreeNode(33);

        root.left = t1;
        root.right = t2;

        t1.left = t11;
        t1.right = null;

        t2.left = null;
        t2.right = t22;

        TreeNode inverted = invertTree(root);
    }
}
