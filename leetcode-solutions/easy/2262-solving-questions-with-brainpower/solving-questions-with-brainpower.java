class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp, 0);
        for(int i=n-1; i>=0 ;i--){
            int p = questions[i][0];
            int j = questions[i][1];

            int nq = Math.min(n, i+j+1);
            dp[i] = Math.max(dp[i+1], p + dp[nq]);
        }
        return dp[0];   
    }
}