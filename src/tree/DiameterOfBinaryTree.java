package tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/submissions/983202725/
 */
public class DiameterOfBinaryTree {

    class Solution {

        int diameter = Integer.MIN_VALUE;

        public int height(TreeNode root) {
            if(root == null) return 0;
            int leftHeight = height(root.left);

            int rightHeight = height(root.right);
            int currentDiameter = leftHeight + rightHeight + 1;
            diameter = Math.max(diameter, currentDiameter);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public int diameterOfBinaryTree(TreeNode root) {
            height(root);
            //we are considering only edges and not nodes.
            return diameter - 1;
        }
    }

    public static void main(String[] args) {

    }
}
