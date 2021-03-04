/*
Ford-Fulkerson algorithm is a greedy approach for calculating the maximum possible flow in a network or a graph.

Ford-Fulkerson Applications
-Water distribution pipeline
-Bipartite matching problem
-Circulation with demands
 */

import java.util.LinkedList;

public class FordFulkerson {
    static final int V = 6;

    boolean bfs(int Graph[][], int s, int t, int p[]) {
        boolean visited[] = new boolean[V];
        for (int i=0; i<V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        p[s] = -1;

        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v=0; v<V; v++) {
                if (visited[v] == false && Graph[u][v]>0) {
                    queue.add(v);
                    p[v] = u;
                    visited[v] = true;
                }
            }
        }

        return (visited[t]);
    }

    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;
        int Graph[][] = new int[V][V];

        for (u=0; u<V; u++) {
            for (v=0; v<V; v++) {
                Graph[u][v] = graph[u][v];
            }
        }

        int[] p = new int[V];

        int maxFlow = 0;

        while (bfs(Graph, s, t, p)) {
            int pathFlow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=p[v]) {
                u = p[v];
                pathFlow = Math.min(pathFlow, Graph[u][v]);
            }

            for (v=t; v!=s; v=p[v]) {
                u = p[v];
                Graph[u][v] -= pathFlow;
                Graph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 8, 0, 0, 3, 0 }, { 0, 0, 9, 0, 0, 0 }, { 0, 0, 0, 0, 7, 2 },
                { 0, 0, 0, 0, 0, 5 }, { 0, 0, 7, 4, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

        FordFulkerson ff = new FordFulkerson();
        System.out.println("Max Flow: " + ff.fordFulkerson(graph, 0, 5));
    }
}
