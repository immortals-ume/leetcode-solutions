class Solution {
    public boolean canPartition(int[] nums) {
                int totalSum = 0;
        for (int num : nums) totalSum += num;

        // If total sum is odd, cannot split into two equal subsets
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // base case: subset with sum 0 is always possible

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}