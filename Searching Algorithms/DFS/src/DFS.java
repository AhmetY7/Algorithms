import java.util.Iterator;
import java.util.LinkedList;

/*
Depth first Search or Depth first traversal is a recursive algorithm for searching all the vertices of a graph
or tree data structure. Traversal means visiting all the nodes of a graph.

Complexity of Depth First Search
The time complexity of the DFS algorithm is represented in the form of O(V + E), where V is the number of nodes
and E is the number of edges.

The space complexity of the algorithm is O(V).

Application of DFS Algorithm
-For finding the path
-To test if the graph is bipartite
-For finding the strongly connected components of a graph
-For detecting cycles in a graph
 */
public class DFS {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    DFS(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i=0; i<vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        adjLists[dest].add(src);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(4);

        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);

        System.out.println("Following is Depth First Traversal");

        dfs.DFS(2);
    }
}
