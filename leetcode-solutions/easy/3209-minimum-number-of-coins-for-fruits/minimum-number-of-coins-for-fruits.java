class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length, dp[] = new int[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && (q.getFirst() + 1) * 2 < i + 1)
                q.removeFirst();
            while (!q.isEmpty() && dp[q.getLast()] + prices[q.getLast()] >= dp[i] + prices[i])
                q.removeLast();
            q.addLast(i);
            dp[i + 1] = dp[q.getFirst()] + prices[q.getFirst()];
        }
        return dp[n];
    }
}