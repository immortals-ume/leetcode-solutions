class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        // Precompute the prefix sum of valid strings
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + 
                           (vowels.contains(first) && vowels.contains(last) ? 1 : 0);
        }
        
        // Process queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0);
        }
        
        return result;
    }
}