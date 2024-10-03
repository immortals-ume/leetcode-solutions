class Solution {
    public int minSubarray(int[] nums, int p) {
         int n = nums.length;
        long totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Calculate the remainder we need to remove
        long targetRemainder = totalSum % p;
        
        // If totalSum is already divisible by p, return 0
        if (targetRemainder == 0) {
            return 0;
        }

        // HashMap to store prefix remainder and the index
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0L, -1);  // To handle cases where the prefix itself is divisible by p

        long prefixSum = 0;
        int minLength = n;

        // Iterate through the array to compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            long currentRemainder = prefixSum % p;

            // Calculate the required remainder that would "cancel out" the targetRemainder
            long requiredRemainder = (currentRemainder - targetRemainder + p) % p;

            // Check if we have seen this remainder before
            if (remainderMap.containsKey(requiredRemainder)) {
                minLength = Math.min(minLength, i - remainderMap.get(requiredRemainder));
            }

            // Store the current remainder and index
            remainderMap.put(currentRemainder, i);
        }

        // If we couldn't find any valid subarray, return -1
        return minLength == n ? -1 : minLength;
    }
}