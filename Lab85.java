import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphTraversal {

    public void addEdge(List<List<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public void DFSRec(List<List<Integer>> adj, boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int i : adj.get(s)) {
            if (!visited[i]) {
                DFSRec(adj, visited, i);
            }
        }
    }

    public void DFS(List<List<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        System.out.println("DFS starting from vertex " + s + ": ");
        DFSRec(adj, visited, s);
        System.out.println();
    }

    public void BFS(List<List<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        System.out.println("BFS starting from vertex " + s + ": ");
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                }
            }
        }
        System.out.println();
    }
}

public class Lab85 {

    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        GraphTraversal graph = new GraphTraversal();

        graph.addEdge(adj, 0, 1);
        graph.addEdge(adj, 0, 2);
        graph.addEdge(adj, 1, 3);
        graph.addEdge(adj, 1, 4);
        graph.addEdge(adj, 2, 4);

        graph.BFS(adj, 0);

        int source = 1;
        graph.DFS(adj, source);
    }
}