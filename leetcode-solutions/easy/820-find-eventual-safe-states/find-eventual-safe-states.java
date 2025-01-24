class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // Reverse the graph and calculate indegrees
        List<List<Integer>> reversedGraph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                reversedGraph.get(v).add(u);
                indegree[u]++;
            }
        }

        // Initialize the queue with terminal nodes (indegree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the nodes
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reversedGraph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Sort the result
        Collections.sort(safeNodes);
        return safeNodes;
    }
}