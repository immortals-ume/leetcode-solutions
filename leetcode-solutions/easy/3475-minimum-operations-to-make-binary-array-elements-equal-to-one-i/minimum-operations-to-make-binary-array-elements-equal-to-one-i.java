class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i <= n - 3; i++) { // Ensure we can flip a group of 3
            if (nums[i] == 0) { // If we find a 0, we need to flip
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                operations++;
            }
        }

        // If there are any remaining 0s at the end, return -1
        return (nums[n - 2] == 1 && nums[n - 1] == 1) ? operations : -1;
    }
}