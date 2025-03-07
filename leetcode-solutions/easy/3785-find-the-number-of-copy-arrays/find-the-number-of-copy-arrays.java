class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        
        // Define the valid range for copy[0]
        int low = bounds[0][0], high = bounds[0][1];

        // Iterate through the array to maintain valid ranges
        for (int i = 1; i < n; i++) {
            int diff = original[i] - original[i - 1];

            // Compute the valid range for copy[i] based on copy[i-1]
            low += diff;
            high += diff;

            // Intersect with the given bounds for copy[i]
            low = Math.max(low, bounds[i][0]);
            high = Math.min(high, bounds[i][1]);

            // If the range is invalid, return 0
            if (low > high) {
                return 0;
            }
        }

        // The number of valid sequences is the number of choices for copy[0]
        return high - low + 1;
    }
}