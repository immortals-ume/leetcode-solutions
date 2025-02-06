class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        // Step 1: Sort each row in ascending order
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        // Step 2: Process columns from right to left
        for (int col = n - 1; col >= 0; col--) {
            int maxInColumn = 0;
            for (int row = 0; row < m; row++) {
                maxInColumn = Math.max(maxInColumn, grid[row][col]);
            }
            result += maxInColumn; // Add the max of this column to the result
        }

        return result;
    }
}