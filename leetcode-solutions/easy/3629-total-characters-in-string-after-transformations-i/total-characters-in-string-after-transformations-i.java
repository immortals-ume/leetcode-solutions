class Solution {
     private static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
         int[] counts = new int[26];  // counts[i] = number of 'a' + i characters

        // Initialize counts from input string
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            int[] newCounts = new int[26];

            // a -> y shift to next char
            for (int i = 0; i < 25; i++) {
                newCounts[i + 1] = (newCounts[i + 1] + counts[i]) % MOD;
            }

            // z -> ab
            newCounts[0] = (newCounts[0] + counts[25]) % MOD;
            newCounts[1] = (newCounts[1] + counts[25]) % MOD;

            counts = newCounts;
        }

        // Total characters = sum of counts
        long total = 0;
        for (int count : counts) {
            total = (total + count) % MOD;
        }

        return (int) total;
    }
}