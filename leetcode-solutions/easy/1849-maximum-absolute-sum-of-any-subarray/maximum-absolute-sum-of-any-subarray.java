class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prefixSum = 0, minSum = 0, maxSum = 0;

        for (int num : nums) {
            prefixSum += num;
            minSum = Math.min(minSum, prefixSum);
            maxSum = Math.max(maxSum, prefixSum);
        }

        return maxSum - minSum;
    }
}