class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0;

        // Create an array of pairs (value, index)
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort by value, then by index
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Iterate through sorted pairs
        for (int[] pair : pairs) {
            int value = pair[0];
            int index = pair[1];

            // If the element is already marked, skip it
            if (marked[index]) continue;

            // Add the value to the score
            score += value;

            // Mark the element and its adjacent elements
            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < n - 1) marked[index + 1] = true;
        }

        return score;
    }
}