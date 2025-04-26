class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
         int n = nums.length;
        long[] ans = new long[n];
        int[] parent = new int[n];
        long[] sum = new long[n];
        boolean[] active = new boolean[n];
        
        // Union Find parent init
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        long max = 0;

        // Find function with path compression
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                if (parent[x] != x) parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };

        // process in reverse
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = max;
            int idx = removeQueries[i];
            active[idx] = true;
            sum[idx] = nums[idx];
            // check left
            if (idx > 0 && active[idx - 1]) {
                int l = find.applyAsInt(idx - 1);
                int r = find.applyAsInt(idx);
                parent[r] = l;
                sum[l] += sum[r];
            }
            // check right
            if (idx + 1 < n && active[idx + 1]) {
                int l = find.applyAsInt(idx);
                int r = find.applyAsInt(idx + 1);
                parent[r] = l;
                sum[l] += sum[r];
            }
            max = Math.max(max, sum[find.applyAsInt(idx)]);
        }
        return ans;
    }
}