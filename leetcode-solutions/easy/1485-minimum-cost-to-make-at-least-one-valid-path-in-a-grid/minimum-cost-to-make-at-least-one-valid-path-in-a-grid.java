class Solution {
    public int minCost(int[][] grid) {
 int m = grid.length, n = grid[0].length;

        // Directions: Right, Left, Down, Up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Cost array to store the minimum cost to reach each cell
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        // Deque for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + directions[d][0];
                int ny = y + directions[d][1];

                // Check if the next position is within bounds
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    // Determine the cost: 0 if following the current direction, otherwise 1
                    int newCost = cost[x][y] + (grid[x][y] == d + 1 ? 0 : 1);

                    // If we find a lower cost, update and add to the deque
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        if (grid[x][y] == d + 1) {
                            deque.offerFirst(new int[]{nx, ny}); // 0-cost move, higher priority
                        } else {
                            deque.offerLast(new int[]{nx, ny}); // 1-cost move, lower priority
                        }
                    }
                }
            }
        }

        return cost[m - 1][n - 1]; // Return the cost to reach the bottom-right cell
    }
}