class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;

        // Check adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return Boolean.FALSE; // Found two adjacent numbers with same parity
            }
        }
        return Boolean.TRUE; // If no violations, return true
    }
}