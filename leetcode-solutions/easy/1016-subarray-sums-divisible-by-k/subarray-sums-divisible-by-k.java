class Solution {
    public int subarraysDivByK(int[] nums, int k) {
              // HashMap to store frequency of prefix sum moduli
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, 1);  // Initialize with 0:1 to handle cases where the prefix sum itself is divisible by k
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            int mod = prefixSum % k;
            
            // Adjust for negative mod
            if (mod < 0) mod += k;
            
            // If this mod value has been seen before, it contributes to the count
            count += modMap.getOrDefault(mod, 0);
            
            // Update the frequency of this mod value
            modMap.put(mod, modMap.getOrDefault(mod, 0) + 1);
        }
        
        return count;
    }
}