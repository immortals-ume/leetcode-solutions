class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minOperations = Integer.MAX_VALUE;
        int currentOperations = 0;

        // Count the number of 'W' in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currentOperations++;
            }
        }
        minOperations = currentOperations;

        // Slide the window across the string
        for (int i = k; i < n; i++) {
            // Remove the character that is sliding out of the window
            if (blocks.charAt(i - k) == 'W') {
                currentOperations--;
            }
            // Add the new character coming into the window
            if (blocks.charAt(i) == 'W') {
                currentOperations++;
            }
            // Update the minimum operations required
            minOperations = Math.min(minOperations, currentOperations);
        }

        return minOperations;
    }
}