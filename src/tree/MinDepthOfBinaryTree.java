package tree;


/**
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public class MinDepthOfBinaryTree {

        public int minDepth2ndOption(TreeNode root) {
            // empty tree
            if (root == null) {
                return 0;
            }

            // leaf node.
            if (root.left == null && root.right == null) {
                return 1;
            }

            // if either of the children node is null
            if (root.left == null) {
                return minDepth(root.right) + 1;
            } else if (root.right == null) {
                return minDepth(root.left) + 1;
            }

            // if we reach here, meaning node has left and right nodes.
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

        }


        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int leftDepth = Integer.MAX_VALUE;
            int rightDepth = Integer.MAX_VALUE;

            if (root.left != null) {
                leftDepth = minDepth(root.left);
            }
            if (root.right != null) {
                rightDepth = minDepth(root.right);
            }

            return Math.min(leftDepth, rightDepth) + 1;

        }
    }
}
