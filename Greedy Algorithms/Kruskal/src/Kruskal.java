import java.util.Arrays;

/*

Kruskal's algorithm is a minimum spanning tree algorithm that takes a graph as input and finds the subset of
the edges of that graph which

-form a tree that includes every vertex
-has the minimum sum of weights among all the trees that can be formed from the graph

Kruskal's Algorithm Complexity
The time complexity Of Kruskal's Algorithm is: O(E log E).

Kruskal's Algorithm Applications
-In order to layout electrical wiring
-In computer network (LAN connection)
 */
public class Kruskal {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset{
        int parent, rank;
    }

    int vertices, edges;
    Edge[] edge;

    Kruskal(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i=0; i<e; ++i) {
            edge[i] = new Edge();
        }
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank)
            subsets[xRoot].parent = yRoot;
        else if (subsets[xRoot].rank > subsets[yRoot].rank)
            subsets[yRoot].parent = xRoot;
        else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    void kruskal() {
        Edge[] result = new Edge[vertices];
        int e = 0;
        int i = 0;
        for (i=0; i<vertices; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);
        Subset[] subsets = new Subset[vertices];
        for (i=0; i<vertices; ++i)
            subsets[i] = new Subset();

        for (int v=0; v<vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e<vertices-1) {
            Edge nextEdge = new Edge();
            nextEdge = edge[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }
        for (i=0; i<e; i++)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }

    public static void main(String[] args) {
        int vertices = 6;
        int edges = 8;
        Kruskal k = new Kruskal(vertices, edges);

        k.edge[0].src = 0;
        k.edge[0].dest = 1;
        k.edge[0].weight = 4;

        k.edge[1].src = 0;
        k.edge[1].dest = 2;
        k.edge[1].weight = 4;

        k.edge[2].src = 1;
        k.edge[2].dest = 2;
        k.edge[2].weight = 2;

        k.edge[3].src = 2;
        k.edge[3].dest = 3;
        k.edge[3].weight = 3;

        k.edge[4].src = 2;
        k.edge[4].dest = 5;
        k.edge[4].weight = 2;

        k.edge[5].src = 2;
        k.edge[5].dest = 4;
        k.edge[5].weight = 4;

        k.edge[6].src = 3;
        k.edge[6].dest = 4;
        k.edge[6].weight = 3;

        k.edge[7].src = 5;
        k.edge[7].dest = 4;
        k.edge[7].weight = 3;

        k.kruskal();
    }
}
