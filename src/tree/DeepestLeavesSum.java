package tree;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 */
public class DeepestLeavesSum {
    int height;
    int deepestSum = 0;

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void preOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (level == height) {
                deepestSum += root.val;
            }
        }
        preOrder(root.left, level + 1);
        preOrder(root.right, level + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        // max depth
        // print all paths from root to leaf
        // select only those paths, matching max depth and make total.
        if (root == null) {
            return 0;
        }
        height = maxDepth(root);
        preOrder(root, 1);
        return deepestSum;
    }
}