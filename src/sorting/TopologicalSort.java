package sorting;

import java.util.*;

public class TopologicalSort {

    // Function to perform topological sorting
    public static List<Integer> topologicalSort(int totalNodes, List<List<Integer>> adjacencyList) {

        int[] indegree = new int[totalNodes];

        // Step 1: Calculate indegree of every node
        for (int node = 0; node < totalNodes; node++) {
            for (int neighbor : adjacencyList.get(node)) {
                indegree[neighbor]++;
            }
        }

        // Step 2: Add all nodes with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < totalNodes; node++) {
            if (indegree[node] == 0) {
                queue.add(node);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        // Step 3: Process the queue
        while (!queue.isEmpty()) {

            int currentNode = queue.poll();
            topoOrder.add(currentNode);

            // Reduce indegree of neighbors
            for (int neighbor : adjacencyList.get(currentNode)) {
                indegree[neighbor]--;

                // If indegree becomes 0, add to queue
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return topoOrder;
    }

    public static void main(String[] args) {

        /*
            Sample Graph (DAG):

                0 → 1 → 2
                ↓
                3

            Adjacency List:
                0: 1, 3
                1: 2
                2: (none)
                3: (none)

            Valid Topological Sort:
                0 1 3 2
                or
                0 3 1 2
        */

        int totalNodes = 4;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(3);
        adjacencyList.get(1).add(2);

        List<Integer> result = topologicalSort(totalNodes, adjacencyList);

        System.out.println("Topological Sort Order: " + result);
    }
}
