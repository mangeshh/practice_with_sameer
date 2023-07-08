package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindIfPathExists {

    public void createAdjacencyList(HashMap<Integer, List<Integer>> adj, int[][] edges, int n) {
        for (int i = 0; i < n; ++i) {
            adj.put(i, new ArrayList<>());
        }

        for (int e = 0; e < edges.length; ++e) {
            int x = edges[e][0];
            int y = edges[e][1];

            adj.get(x).add(y);
            adj.get(y).add(x); // if we comment this line then it will fail, see below comments.

            // 1 -- 0

            // adj[1] = {0}
            // adj[0] = {}

            // System.out.println(adj);
        }
    }

    public void dfs(int currentNode, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[currentNode] = true;
        for (int neighborNode : adj.get(currentNode)) {
            if (!visited[neighborNode]) {
                dfs(neighborNode, adj, visited);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        createAdjacencyList(adj, edges, n);
        dfs(source, adj, visited);
        return visited[destination];

    }
}
