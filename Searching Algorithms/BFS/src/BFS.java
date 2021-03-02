import java.util.Iterator;
import java.util.LinkedList;

/*
Traversal means visiting all the nodes of a graph. Breadth First Traversal or Breadth First Search is a recursive
algorithm for searching all the vertices of a graph or tree data structure.

The time complexity of the BFS algorithm is represented in the form of O(V + E), where V is the number of nodes
and E is the number of edges.

The space complexity of the algorithm is O(V).

BFS Algorithm Applications
-To build index by search index
-For GPS navigation
-Path finding algorithms
-In Ford-Fulkerson algorithm to find maximum flow in a network
-Cycle detection in an undirected graph
-In minimum spanning tree
 */
public class BFS {
    private int v;
    private LinkedList<Integer> adj[];

    BFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3,3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        bfs.BFS(2);
    }
}
