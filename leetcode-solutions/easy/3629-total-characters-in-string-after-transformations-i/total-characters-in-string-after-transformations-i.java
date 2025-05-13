class Solution {
     private static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int[][] dp = new int[t + 1][26];

        // Initial character frequencies from string
        for (char ch : s.toCharArray()) {
            dp[0][ch - 'a']++;
        }

        // Fill DP table
        for (int i = 1; i <= t; i++) {
            for (int c = 0; c < 26; c++) {
                int count = dp[i - 1][c];
                if (c < 25) {
                    dp[i][c + 1] = (dp[i][c + 1] + count) % MOD;
                } else {
                    dp[i][0] = (dp[i][0] + count) % MOD;  // 'z' -> 'a'
                    dp[i][1] = (dp[i][1] + count) % MOD;  // 'z' -> 'b'
                }
            }
        }

        // Sum all characters at time t
        long total = 0;
        for (int c = 0; c < 26; c++) {
            total = (total + dp[t][c]) % MOD;
        }

        return (int) total;
    }
}