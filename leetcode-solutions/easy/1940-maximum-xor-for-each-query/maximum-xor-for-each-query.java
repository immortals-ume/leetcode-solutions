class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
           int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the initial XOR of all elements in nums
        int currentXOR = 0;
        for (int num : nums) {
            currentXOR ^= num;
        }
        
        // Mask for limiting k within the range of maximumBit
        int mask = (1 << maximumBit) - 1;
        
        // For each query, calculate k and update currentXOR by removing the last element
        for (int i = 0; i < n; i++) {
            // Calculate k to maximize XOR (bitwise complement of currentXOR within maximumBit range)
            result[i] = currentXOR ^ mask;
            // Remove the last element in current nums by XOR-ing with currentXOR
            currentXOR ^= nums[n - 1 - i];
        }
        
        return result;
    }
}