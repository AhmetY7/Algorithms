/*
Floyd-Warshall Algorithm is an algorithm for finding the shortest path between all the pairs of vertices in a weighted
graph. This algorithm works for both the directed and undirected weighted graphs. But, it does not work for the graphs
with negative cycles (where the sum of the edges in a cycle is negative).

This algorithm follows the dynamic programming approach to find the shortest paths.

Time Complexity
There are three loops. Each loop has constant complexities. So, the time complexity of the Floyd-Warshall algorithm
is O(n3).

Space Complexity
The space complexity of the Floyd-Warshall algorithm is O(n2).

Floyd Warshall Algorithm Applications

To find the shortest path is a directed graph
To find the transitive closure of directed graphs
To find the Inversion of real matrices
For testing whether an undirected graph is bipartite
 */
public class FloydWarshall {
    final static int INF = Integer.MAX_VALUE, nV = 4;

    void floydWarshall(int graph[][]) {
        int matrix[][] = new int[nV][nV];
        int i, j, k;

        for (i=0; i<nV; i++) {
            for (j = 0; j < nV; j++) {
                matrix[i][j] = graph[i][j];
            }
        }

        for (k=0; k<nV; k++) {
            for (i=0; i<nV; i++) {
                for (j=0; j<nV; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    void printMatrix(int matrix[][]) {
        for (int i=0; i<nV; ++i) {
            for (int j=0; j<nV; ++j) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph);
    }

}
