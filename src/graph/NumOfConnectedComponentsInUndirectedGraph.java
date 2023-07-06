package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 */
public class NumOfConnectedComponentsInUndirectedGraph {

    public void dfs(int currentNode, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[currentNode] = true;
        for (int neighborNode : adj.get(currentNode)) {
            if (!visited[neighborNode]) {
                dfs(neighborNode, adj, visited);
            }
        }
    }

    public void createAdjacencyList(HashMap<Integer, List<Integer>> adj, int[][] edges, int n) {
        for (int i = 0; i < n; ++i) {
            adj.put(i, new ArrayList<>());
        }

        for (int e = 0; e < edges.length; ++e) {
            int x = edges[e][0];
            int y = edges[e][1];

            adj.get(x).add(y);
            adj.get(y).add(x);
        }
    }

    public int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        createAdjacencyList(adj, edges, n);

        int components = 0;
        for (int node = 0; node < n; ++node) {
            if (!visited[node]) {
                components++;
                dfs(node, adj, visited);
            }
        }

        return components;
    }
}
