class Solution {
    public int maxAscendingSum(int[] nums) {
         int maxSum = 0, currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];  // Continue the ascending sequence
            } else {
                maxSum = Math.max(maxSum, currentSum);  // Update max sum
                currentSum = nums[i];  // Start a new subarray
            }
        }
        return Math.max(maxSum, currentSum);  // Final update for last subarray
    }
}