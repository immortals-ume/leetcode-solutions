class Solution {
    public long countBadPairs(int[] nums) {
         Map<Integer, Integer> diffCount = new HashMap<>();
        long totalPairs = (long) nums.length * (nums.length - 1) / 2;
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            if (diffCount.containsKey(diff)) {
                goodPairs += diffCount.get(diff);
            }
            diffCount.put(diff, diffCount.getOrDefault(diff, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}