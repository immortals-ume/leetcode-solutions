class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Create a copy of the array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // Step 2: Create a rank map for the unique elements
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        
        // Step 3: Replace each element in the original array with its rank
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}