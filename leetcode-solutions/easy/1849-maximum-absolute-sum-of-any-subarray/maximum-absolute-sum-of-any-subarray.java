class Solution {
    public int maxAbsoluteSum(int[] nums) {
       int maxSum = 0, minSum = 0, maxAbsSum = 0;
        int currentMax = 0, currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            maxAbsSum = Math.max(maxAbsSum, Math.max(maxSum, -minSum));
        }
        
        return maxAbsSum;
    }
}