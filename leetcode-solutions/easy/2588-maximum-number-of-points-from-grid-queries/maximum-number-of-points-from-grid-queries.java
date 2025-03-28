class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
         int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] answer = new int[k];

        // Sort queries with their original indices
        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        // Min-Heap (Dijkstra-like BFS)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        // Visited set to track already counted cells
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        // Directions: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0, index = 0;

        while (index < k) {
            int queryVal = sortedQueries[index][0];
            int originalIndex = sortedQueries[index][1];

            // Expand all cells from heap that are less than current query
            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryVal) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                count++; // Cell contributes a point

                // Explore neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

            // Store result for this query
            answer[originalIndex] = count;
            index++;
        }

        return answer;
    }
}