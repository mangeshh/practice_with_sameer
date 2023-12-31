package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * we are using counter to find time complexity (this graph is un directional (meaning, bi-directional)
 *
 */
public class NumOfConnectedComponentsInUndirectedGraph {

    public static void dfs(int currentNode, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[currentNode] = true;
        for (int neighborNode : adj.get(currentNode)) {
            if (!visited[neighborNode]) {
                dfs(neighborNode, adj, visited);
            }
        }
    }

    public static void createAdjacencyList(HashMap<Integer, List<Integer>> adj, int[][] edges, int n) {
        for (int i = 0; i < n; ++i) {
            adj.put(i, new ArrayList<>()); // from that node (key of map), how many connect nodes, going in/out (values of map)
        }

        for (int e = 0; e < edges.length; ++e) {
            int x = edges[e][0];
            int y = edges[e][1];

            adj.get(x).add(y);
            adj.get(y).add(x); // if we comment this line then it will fail, see below comments.
        }
    }

    public static int countComponents(int n, int[][] edges) {
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
        System.out.println("counter " + components);
        return components;
    }

    public static void main(String[] args) {
        int [][]edges = new int [][]{{0,1},{1,2},{2,0}};
        countComponents(3, edges);
    }
}
