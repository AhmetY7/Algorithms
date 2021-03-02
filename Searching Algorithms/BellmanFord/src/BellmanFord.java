/*
Bellman Ford algorithm helps us find the shortest path from a vertex to all other vertices of a weighted graph.

It is similar to Dijkstra's algorithm but it can work with graphs in which edges can have negative weights.

Bellman Ford's Complexity

-Time Complexity
-Best Case Complexity	O(E)
-Average Case Complexity	O(VE)
-Worst Case Complexity	O(VE)

Space Complexity

-the space complexity is O(V).

Bellman Ford's Algorithm Applications

For calculating shortest paths in routing algorithms
For finding the shortest path
 */
public class BellmanFord {
    class CreateEdge {
        int s, d, w;

        CreateEdge() {
            s = d = w = 0;
        }
    };

    int v, e;
    CreateEdge[] edge;

    BellmanFord(int v, int e) {
        this.v = v;
        this.e = e;

        edge = new CreateEdge[e];
        for (int i=0; i<e; ++i)
            edge[i] = new CreateEdge();
    }

    void BF(BellmanFord bf, int s) {
        int v = bf.v, e = bf.e;
        int[] dist = new int[v];

        for (int i=0; i<v; ++i)
            dist[i] = Integer.MAX_VALUE;

        dist[s] = 0;

        for (int i=1; i<v; ++i){
            for (int j=0; j<e; ++j) {
                int u = bf.edge[j].s;
                int vv = bf.edge[j].d;
                int w = bf.edge[j].w;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w<dist[vv])
                    dist[vv] = dist[u] + w;
            }
        }

        for (int j=0; j<e; ++j) {
            int u = bf.edge[j].s;
            int vv = bf.edge[j].d;
            int w = bf.edge[j].w;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[vv]) {
                System.out.println("Bellman Ford contains negative w cycle");
                return;
            }
        }

        printSolution(dist, v);
    }

    void printSolution(int dist[], int v) {
        System.out.println("Vertx Distance from Source");
        for (int i=0; i<v; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int v = 5;
        int e = 8;

        BellmanFord bf = new BellmanFord(v, e);

        bf.edge[0].s = 0;
        bf.edge[0].d = 1;
        bf.edge[0].w = 5;

        bf.edge[1].s = 0;
        bf.edge[1].d = 2;
        bf.edge[1].w = 4;

        bf.edge[2].s = 1;
        bf.edge[2].d = 3;
        bf.edge[2].w = 3;

        bf.edge[3].s = 2;
        bf.edge[3].d = 1;
        bf.edge[3].w = 6;

        bf.edge[4].s = 3;
        bf.edge[4].d = 2;
        bf.edge[4].w = 2;

        bf.BF(bf, 0);
    }
}
