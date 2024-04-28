class Solution {
    private List<List<Integer>> tree;
    private int[] res;  // Result array to store sum of distances for each node
    private int[] count;  // Count of nodes in the subtree rooted at each node

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>(n);
        res = new int[n];
        count = new int[n];

        // Initialize the adjacency list
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // First DFS to calculate the initial sum of distances and node counts
        dfsCount(0, -1);

        // Second DFS to propagate the distances to all other nodes
        dfsRes(0, -1, n);

        return res;
    }

    private void dfsCount(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            dfsCount(child, node);
            count[node] += count[child];  // Update subtree node count
            res[0] += count[child];  // Accumulate distance for the root
        }
        count[node] += 1;  // Include the current node in the count
    }

    private void dfsRes(int node, int parent, int n) {
        for (int child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            // Using the transition formula to adjust the distances
            res[child] = res[node] - count[child] + (n - count[child]);
            dfsRes(child, node, n);
        }
    }

}