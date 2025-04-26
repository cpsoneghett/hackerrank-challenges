package leetcode.binary_tree;

public class MaximumDepth {

    public static int maxDepth(TreeNode root) {

        if(root==null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        System.out.println(maxDepth(root));
    }
}
