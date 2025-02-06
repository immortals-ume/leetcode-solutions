class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int n = nums.length;
        if (n == 1) return 1;

        int inc = 1, dec = 1, maxLength = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;  // Reset decreasing subarray
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;  // Reset increasing subarray
            } else {
                inc = 1;
                dec = 1;
            }
            maxLength = Math.max(maxLength, Math.max(inc, dec));
        }

        return maxLength;
    }
}