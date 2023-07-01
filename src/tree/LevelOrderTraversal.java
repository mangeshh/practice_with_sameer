package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> LearningLevelOrderButWrong(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<List<Integer>>();

        if (root == null) {
            return allLevels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> valuesPerLevel = new ArrayList<>();

        queue.add(root);
        valuesPerLevel.add(root.val);
        allLevels.add(valuesPerLevel);


        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            valuesPerLevel = new ArrayList<Integer>();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
                valuesPerLevel.add(currentNode.left.val);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
                valuesPerLevel.add(currentNode.right.val);
            }
            if (valuesPerLevel.size() > 0) {
                allLevels.add(valuesPerLevel);
            }

        }

        return allLevels;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<List<Integer>>();

        if (root == null) {
            return allLevels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> valuesPerLevel = new ArrayList<>();

        queue.add(root);


        while (!queue.isEmpty()) {

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