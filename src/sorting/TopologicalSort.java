package sorting;

import java.util.*;

public class TopologicalSort {

    /*
        Compassionate intuition:

        DFS goes deep first.
        When a node has no unvisited children left,
        we "finish" it and push it into a stack.

        Finished nodes are safe to appear later in the order.

        Final stack (reversed DFS finish order) = Topological Order.
    */

    public static void topologicalSort(int totalNodes, List<List<Integer>> adjacencyList) {

        boolean[] visited = new boolean[totalNodes];
        Deque<Integer> stack = new ArrayDeque<>();

        // Visit all nodes (graph may be disconnected)
        for (int node = 0; node < totalNodes; node++) {
            if (!visited[node]) {
                dfs(node, adjacencyList, visited, stack);
            }
        }

        // Print topological order
        System.out.println("Topological Sort Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dfs(int currentNode,
                            List<List<Integer>> adjacencyList,
                            boolean[] visited,
                            Deque<Integer> stack) {

        visited[currentNode] = true;

        // Visit all children
        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacencyList, visited, stack);
            }
        }

        // All children done → safe to push
        stack.push(currentNode);
    }

    public static void main(String[] args) {

        /*
            Sample Graph (same style as the video):

                5 → 0
                5 → 2
                4 → 0
                4 → 1
                2 → 3
                3 → 1

            Valid Topological Sort:
                5 4 2 3 1 0
                or
                4 5 2 3 1 0
                (many valid answers)
        */

        int totalNodes = 6;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges (directed)
        adjacencyList.get(5).add(0);
        adjacencyList.get(5).add(2);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);

        topologicalSort(totalNodes, adjacencyList);
    }
}
