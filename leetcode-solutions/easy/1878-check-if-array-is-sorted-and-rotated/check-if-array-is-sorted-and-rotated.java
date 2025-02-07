class Solution {
    public boolean check(int[] nums) {
         int count = 0;
        int n = nums.length;
        
        // Count the number of times nums[i] > nums[i+1] (break in sorted order)
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        
        // If there is at most one break point, it can be a rotated sorted array
        return count <= 1;
    }
}