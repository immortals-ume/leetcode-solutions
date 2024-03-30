class Solution {
public static int majorityElement(int[] nums) {
        int count = 0;
        Integer cand = null;

        for (int num : nums) {
            if (count == 0) {
                cand = num;
            }
            count += (num == cand) ? 1 : -1;
        }

        // Second pass to count occurrences of cand
        count = 0;
        for (int num : nums) {
            if (num == cand) {
                count++;
            }
        }

        // Check if cand is the majority element
        return (count > nums.length / 2) ? cand : -1; // -1 indicates no majority element
    }
}