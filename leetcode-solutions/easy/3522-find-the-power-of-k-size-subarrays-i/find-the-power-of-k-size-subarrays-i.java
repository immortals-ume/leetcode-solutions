class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            boolean isValid = true;
            
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j + 1] != nums[j] + 1) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                results[i] = nums[i + k - 1];
            } else {
                results[i] = -1;
            }
        }
        
        return results;
    }
}