class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int start = 0;
        long totalCount = 0;
        int minVal = nums[0], maxVal = nums[0];

        for (int end = 0; end < n; end++) {
            // Update minVal and maxVal for the current window
            minVal = Math.min(minVal, nums[end]);
            maxVal = Math.max(maxVal, nums[end]);

            // Shrink the window if the condition is violated
            while (maxVal - minVal > 2) {
                start++;
                // Recalculate min and max for the new window
                minVal = nums[start];
                maxVal = nums[start];
                for (int k = start; k <= end; k++) {
                    minVal = Math.min(minVal, nums[k]);
                    maxVal = Math.max(maxVal, nums[k]);
                }
            }

            // Add the number of valid subarrays ending at `end`
            totalCount += (end - start + 1);
        }

        return totalCount;
    }
}