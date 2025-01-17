class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
           int n = A.length;
        int[] C = new int[n]; // Array to store the result
        HashSet<Integer> seenA = new HashSet<>(); // Numbers seen in A
        HashSet<Integer> seenB = new HashSet<>(); // Numbers seen in B

        for (int i = 0; i < n; i++) {
            // Add the current numbers to their respective sets
            seenA.add(A[i]);
            seenB.add(B[i]);

            // Count common elements between the two sets
            int commonCount = 0;
            for (int num : seenA) {
                if (seenB.contains(num)) {
                    commonCount++;
                }
            }

            // Update the result array
            C[i] = commonCount;
        }

        return C;
    }
}