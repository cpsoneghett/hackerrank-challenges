package leetcode.binary_tree;

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);

        root1.left = t1;

        TreeNode root2 = new TreeNode(1);
        TreeNode ta = new TreeNode(2);
        TreeNode tb = new TreeNode(1);

        root2.left = ta;
        root2.right = tb;


        System.out.println(isSameTree(root1, root2));
    }
}
