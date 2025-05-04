import java.util.*;

class Graph {
    private final Map<Integer, List<int[]>> adj;

    public Graph(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int start, int goal) {
        // PriorityQueue with [node, gCost, fCost]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Map<Integer, Integer> gScore = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer node : adj.keySet()) {
            gScore.put(node, Integer.MAX_VALUE);
        }

        gScore.put(start, 0);
        pq.offer(new int[]{start, 0, heuristic(start, goal)}); // node, g, f

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], g = current[1];

            if (node == goal) {
                return g;
            }

            if (visited.contains(node)) continue;
            visited.add(node);

            for (int[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0], edgeCost = neighbor[1];
                int tentativeG = g + edgeCost;

                if (tentativeG < gScore.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                    gScore.put(nextNode, tentativeG);
                    int f = tentativeG + heuristic(nextNode, goal);
                    pq.offer(new int[]{nextNode, tentativeG, f});
                }
            }
        }

        return -1;
    }

    // Heuristic function for A*
    // Currently returns 0 (behaves like Dijkstra)
    private int heuristic(int node, int goal) {
        return 0;
    }
}