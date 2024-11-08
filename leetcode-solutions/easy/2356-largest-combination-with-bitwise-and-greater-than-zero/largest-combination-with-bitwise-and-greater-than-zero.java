class Solution {
    public int largestCombination(int[] candidates) {
                int[] bitCount = new int[24]; // Array to count '1's in each bit position

        // Count the number of '1's in each bit position across all numbers
        for (int num : candidates) {
            for (int i = 0; i < 24; i++) {
                if ((num & (1 << i)) != 0) { // Check if the i-th bit is '1'
                    bitCount[i]++;
                }
            }
        }

        // Find the maximum count in bitCount, which is the answer
        int maxCombinationSize = 0;
        for (int count : bitCount) {
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }

        return maxCombinationSize;
    }
}