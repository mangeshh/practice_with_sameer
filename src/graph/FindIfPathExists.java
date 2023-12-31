package graph;

import java.util.*;

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

            //adj is {0=[1, 2], 1=[0, 2], 2=[1, 0], 3=[]}
        }

    }

    @SuppressWarnings("unused")
    public static void dfs(int currentNode, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[currentNode] = true;
        for (int neighborNode : adj.get(currentNode)) {
            if (!visited[neighborNode]) {
                dfs(neighborNode, adj, visited);
            }
        }
    }

    public static void bfs(int currentNode, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(currentNode);
        visited[currentNode] = true;

        while (queue.size() != 0){
            currentNode = queue.poll();
            for(int neighbour: adj.get(currentNode)){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    public static boolean validPath(int nodes, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[nodes];

        // first initiate the graph using map
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        createAdjacencyList(adj, edges, nodes);

        // dfs(source, adj, visited);
        bfs(source, adj, visited);

        return visited[destination];
    }

    public static void main(String[] args) {
        int [][]edges = new int [][]{{0,1},{1,2},{2,0}};
        int source = 3;
        int destination = 3;
        int nodes = 4;

        if(validPath(nodes, edges, source,destination)){
            System.out.println("Path exists from " + source + " to " + destination);
        }
        else{
            System.out.println("Path does not exists from " + source + " to " + destination);
        }

    }
}
