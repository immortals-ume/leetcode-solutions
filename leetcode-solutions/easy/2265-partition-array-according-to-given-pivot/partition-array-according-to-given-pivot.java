class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
           List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                left.add(num);
            } else if (num == pivot) {
                mid.add(num);
            } else {
                right.add(num);
            }
        }

        // Merge lists
        left.addAll(mid);
        left.addAll(right);

        // Convert list back to array
        return left.stream().mapToInt(i -> i).toArray();
    }
}