class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
         int xor1 = 0, xor2 = 0;

        // XOR all elements in nums1
        for (int num : nums1) {
            xor1 ^= num;
        }

        // XOR all elements in nums2
        for (int num : nums2) {
            xor2 ^= num;
        }

        // If both arrays have even length, all pairings cancel out
        if (nums1.length % 2 == 0 && nums2.length % 2 == 0) {
            return 0;
        }

        // If only nums1 has an odd length, xor2 contributes
        if (nums1.length % 2 == 1 && nums2.length % 2 == 0) {
            return xor2;
        }

        // If only nums2 has an odd length, xor1 contributes
        if (nums1.length % 2 == 0 && nums2.length % 2 == 1) {
            return xor1;
        }

        // If both have odd lengths, both xor1 and xor2 contribute
        return xor1 ^ xor2;
    }
}