package tree;

import static backtracking.SortedArrayToBinarySearchTree.inOrder;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class MaxDifferenceBetweenNodeFromAncestor {
    static int maxDifference = 0;

    public static void helper(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }

        System.out.println(" current root: " + root.val + " max: " + max + ", min: " + min);

        maxDifference = Math.max(maxDifference, Math.abs(root.val - max));
        maxDifference = Math.max(maxDifference, Math.abs(root.val - min));

        if (root.left != null) {
            helper(root.left, Math.max(root.left.val, max), Math.min(root.left.val, min));
        }
        if (root.right != null) {
            helper(root.right, Math.max(root.right.val, max), Math.min(root.right.val, min));
        }

    }

    public static int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return maxDifference;
    }


    /**
     *
     *               7
     *
     *        3            12
     *
     *     1     5      10     14
     *
     * @param args
     */
    public static void main(String[] args) {
        // root
        TreeNode root = new TreeNode(7);

        // root's left side
        TreeNode root_left = new TreeNode(3);
        root.left = root_left;

        TreeNode root_left_left = new TreeNode(1);
        root_left.left = root_left_left;

        TreeNode root_left_right = new TreeNode(5);
        root_left.right = root_left_right;

        // root's right side
        TreeNode root_right = new TreeNode(12);
        root.right = root_right;

        TreeNode root_right_left = new TreeNode(10);
        root_right.left = root_right_left;

        TreeNode root_right_right = new TreeNode(14);
        root_right.right = root_right_right;

        TreeNode.inOrderTraversal(root);

        System.out.println("answer is " + maxAncestorDiff(root));

    }
}