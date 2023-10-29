package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<List<Integer>>();

        if (root == null) {
            return allLevels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> valuesPerLevel = new ArrayList<>();

        queue.add(root);


        while (!queue.isEmpty()) {
            // queue size is the key here
            int size = queue.size();
            valuesPerLevel = new ArrayList<Integer>();

            for (int i = 0; i < size; ++i) {
                TreeNode currentNode = queue.poll();
                valuesPerLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            allLevels.add(valuesPerLevel);

        }

        return allLevels;
    }

}