class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
                List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;

        while (i < n1 && j < n2) {
            if (nums1[i][0] == nums2[j][0]) {
                // Matching IDs, sum the values
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]); // Unique ID in nums1
                i++;
            } else {
                result.add(nums2[j]); // Unique ID in nums2
                j++;
            }
        }

        // Add remaining elements from nums1
        while (i < n1) {
            result.add(nums1[i++]);
        }

        // Add remaining elements from nums2
        while (j < n2) {
            result.add(nums2[j++]);
        }

        // Convert result list to array
        return result.toArray(new int[result.size()][]);
    }
}