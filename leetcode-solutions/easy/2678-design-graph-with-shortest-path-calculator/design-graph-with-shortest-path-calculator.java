import java.util.*;

class Graph {
    private final int INF = (int) 1e9;
    private int[][] dist;
    private int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        dist = new int[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
        }

        floydWarshall();
    }

    private void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0], v = edge[1], w = edge[2];
        if (dist[u][v] > w) {
            dist[u][v] = w;
            floydWarshall(); // Recompute all-pairs shortest paths
        }
    }

    public int shortestPath(int node1, int node2) {
        return dist[node1][node2] >= INF ? -1 : dist[node1][node2];
    }
}