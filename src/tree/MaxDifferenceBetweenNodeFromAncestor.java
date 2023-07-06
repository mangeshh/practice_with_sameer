package tree;


/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class MaxDifferenceBetweenNodeFromAncestor {
    int maxDifference = 0;

    public void helper(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }

        System.out.println(root.val + " " + max + " " + min);

        maxDifference = Math.max(maxDifference, Math.abs(root.val - max));
        maxDifference = Math.max(maxDifference, Math.abs(root.val - min));

        if (root.left != null) {
            helper(root.left, Math.max(root.left.val, max), Math.min(root.left.val, min));
        }
        if (root.right != null) {
            helper(root.right, Math.max(root.right.val, max), Math.min(root.right.val, min));
        }

    }

    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return maxDifference;
    }
}