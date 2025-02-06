class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<>();
        int count = 0;

        // Generate all pairs and count product frequencies
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }

        // Calculate valid tuples
        for (int freq : productMap.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1) / 2) * 8; // 8 permutations
            }
        }

        return count;
    }
}