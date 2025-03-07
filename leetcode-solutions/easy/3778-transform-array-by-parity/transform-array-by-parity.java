class Solution {
    public int[] transformArray(int[] nums) {
        // Step 1: Replace even with 0, odd with 1
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] % 2 == 0) ? 0 : 1;
        }

        // Step 2: Sort the array
        Arrays.sort(nums);
        
        return nums;
    }
}