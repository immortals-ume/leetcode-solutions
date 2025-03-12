class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        
        // Find the first positive number using binary search
        int posIndex = findFirstGreaterOrEqual(nums, 1);
        
        // Find the first zero (or smallest non-negative number)
        int zeroIndex = findFirstGreaterOrEqual(nums, 0);
        
        // Number of negative numbers is from index 0 to zeroIndex - 1
        int negCount = zeroIndex;
        
        // Number of positive numbers is from posIndex to the end
        int posCount = n - posIndex;
        
        return Math.max(negCount, posCount);
    }

    // Binary search to find the first index where nums[index] >= target
    private int findFirstGreaterOrEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // First index where nums[index] >= target
    }
}