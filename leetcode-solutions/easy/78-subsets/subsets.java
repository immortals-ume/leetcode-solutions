class Solution {
    public List<List<Integer>> subsets(int[] nums) {
           Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }
    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index >= nums.length) {
            subsets.add(current);
            return;
        }
        if (index == 0 || nums[index] != nums[index - 1]) {
            generateSubsets(nums, index + 1, new ArrayList<>(current), subsets);
        }
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, subsets);
    }
}