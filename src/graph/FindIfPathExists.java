package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindIfPathExists {

    public static void createAdjacencyList(HashMap<Integer, List<Integer>> adj, int[][] edges, int n) {
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

    public static void dfs(int currentNode, HashMap<Integer, List<Integer>> adj, boolean[] visited, int counter) {
        visited[currentNode] = true;
        for (int neighborNode : adj.get(currentNode)) {
            if (!visited[neighborNode]) {
                dfs(neighborNode, adj, visited, counter++);
            }
        }
    }


    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[n];
        int counter = 0;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        createAdjacencyList(adj, edges, n);
        dfs(source, adj, visited, counter++);
        System.out.println("counter " + counter);
        return visited[destination];
    }

    public static void main(String[] args) {
        int [][]edges = new int [][]{{0,1},{1,2},{2,0}};
        validPath(3, edges, 0,1);

    }
}