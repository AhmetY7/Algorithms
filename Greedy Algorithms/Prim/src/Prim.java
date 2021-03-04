import java.util.Arrays;

/*
Prim's algorithm is a minimum spanning tree algorithm that takes a graph as input and finds the subset of the edges
of that graph which

form a tree that includes every vertex
has the minimum sum of weights among all the trees that can be formed from the graph

 Prim's vs Kruskal's Algorithm
Kruskal's algorithm is another popular minimum spanning tree algorithm that uses a different logic to find the
MST of a graph. Instead of starting from a vertex, Kruskal's algorithm sorts all the edges from low weight to high
and keeps adding the lowest edges, ignoring those edges that create a cycle.

Prim's Algorithm Complexity
-The time complexity of Prim's algorithm is O(E log V).

Prim's Algorithm Application
-Laying cables of electrical wiring
-In network designed
-To make protocols in network cycles
 */
public class Prim {
    public void Prim(int G[][], int V) {
        int INF = Integer.MAX_VALUE;
        int noEdge;

        boolean[] selected = new boolean[V];

        Arrays.fill(selected, false);

        noEdge = 0;

        selected[0] = true;

        System.out.println("Edge : Weight");

        while (noEdge<V-1) {
            int min = INF;
            int x = 0;
            int y = 0;

            for (int i=0; i<V; i++) {
                if (selected[i]) {
                    for (int j=0; j<V; j++) {
                        if (!selected[j] && G[i][j] != 0) {
                            if (min>G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x +" - " + y + " : " + G[x][y]);
            selected[y] = true;
            noEdge++;
        }
    }

    public static void main(String[] args) {
        Prim g = new Prim();

        int V = 5;

        int[][] G = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
                { 0, 42, 66, 31, 0 } };

        g.Prim(G, V);
    }
}
