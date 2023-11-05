package tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaxHeightOfTree {
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();
        TreeNode t2 = new TreeNode();
        TreeNode t3 = new TreeNode();
        TreeNode t4 = new TreeNode();
        TreeNode t5 = new TreeNode();
        TreeNode t6 = new TreeNode();
        TreeNode t7 = new TreeNode();

        t1.left = t2;
        t1.right = t3;
        t1.val = 1;

        t2.left = t4;
        t2.right = t5;
        t2.val = 2;

        t3.left = t6;
        t3.right = t7;
        t3.val = 3;

        t4.left = null;
        t4.right = null;
        t4.val = 4;

        System.out.println(maxDepth(t1));
    }
}

