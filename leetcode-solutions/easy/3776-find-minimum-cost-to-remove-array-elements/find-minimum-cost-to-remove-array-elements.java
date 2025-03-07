class Solution {
 public int cal(int ext, int ind, int[] nums, int[][] dp) {
        // Single element left
        if (ind == nums.length) return nums[ext];

        // 2 Elements left
        if (ind == nums.length - 1) return Math.max(nums[ext], nums[ind]);

        if (dp[ind][ext] != -1) return dp[ind][ext];

        // Trying all 3 cases of choosing 2 elements
        int f = Math.max(nums[ind], nums[ind + 1]) + cal(ext, ind + 2, nums, dp);
        int s = Math.max(nums[ext], nums[ind + 1]) + cal(ind, ind + 2, nums, dp);
        int t = Math.max(nums[ext], nums[ind]) + cal(ind + 1, ind + 2, nums, dp);

        // Returning min among the 3
        return dp[ind][ext] = Math.min(f, Math.min(s, t));
    }

    public int minCost(int[] nums) {
        int n = nums.length;

        // Memoization Table
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return cal(0, 1, nums, dp);
    }
}