class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; // Edge case
        
        // Step 1: Compute suffix maximums for nums[k] (k > j)
        int[] maxSuffix = new int[n];
        maxSuffix[n - 1] = nums[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            maxSuffix[k] = Math.max(maxSuffix[k + 1], nums[k]);
        }

        // Step 2: Iterate through j and track maxPrefix
        int maxPrefix = nums[0]; // nums[i] before j
        long maxValue = 0;

        for (int j = 1; j < n - 1; j++) {
            if (maxPrefix > nums[j]) { // Ensure (nums[i] - nums[j]) is positive
                long value = (long) (maxPrefix - nums[j]) * maxSuffix[j + 1];
                maxValue = Math.max(maxValue, value);
            }
            maxPrefix = Math.max(maxPrefix, nums[j]); // Update prefix max
        }

        return maxValue;
    }
}