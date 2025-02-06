class Solution {
    public int deleteGreatestValue(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        // Step 1: Create a max heap (priority queue) for each row
        PriorityQueue<Integer>[] rowHeaps = new PriorityQueue[m];
        for (int i = 0; i < m; i++) {
            rowHeaps[i] = new PriorityQueue<>((a, b) -> b - a); // Max Heap
            for (int num : grid[i]) {
                rowHeaps[i].add(num);
            }
        }

        // Step 2: Process each column by removing the max element from each row
        for (int col = 0; col < n; col++) {
            int maxInColumn = 0;
            for (int row = 0; row < m; row++) {
                if (!rowHeaps[row].isEmpty()) {
                    int removedValue = rowHeaps[row].poll(); // Remove max from row
                    maxInColumn = Math.max(maxInColumn, removedValue);
                }
            }
            result += maxInColumn; // Add max of this column to the result
        }

        return result;
    }
}