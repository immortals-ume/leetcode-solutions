class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> numCount = new HashMap<>();
        int repeated = -1, missing = -1;

        // Count occurrences of each number
        for (int[] row : grid) {
            for (int num : row) {
                numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }
        }

        // Check numbers from 1 to n^2
        for (int num = 1; num <= n * n; num++) {
            int count = numCount.getOrDefault(num, 0);
            if (count == 2) {
                repeated = num;
            } else if (count == 0) {
                missing = num;
            }
        }

        return new int[]{repeated, missing};
    }
}