package leetcode.binary_tree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if(root == null)
            return true;

        TreeNode left = root.left;
        TreeNode right = root.right;

        return isMirror(left, right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;

        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
