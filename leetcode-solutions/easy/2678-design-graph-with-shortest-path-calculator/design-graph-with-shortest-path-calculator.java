import java.util.*;

class Graph {
    private Map<Integer, List<int[]>> adj;

    public Graph(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]}); // [to, cost]
        }
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        pq.offer(new int[]{node1, 0}); // [node, cost]

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], cost = curr[1];
            if (node == node2) return cost;
            if (visited.contains(node)) continue;
            visited.add(node);

            for (int[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0], edgeCost = neighbor[1];
                if (!visited.contains(nextNode)) {
                    pq.offer(new int[]{nextNode, cost + edgeCost});
                }
            }
        }

        return -1; // No path found
    }
}