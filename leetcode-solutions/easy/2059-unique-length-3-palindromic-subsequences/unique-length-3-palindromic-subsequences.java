class Solution {
    public int countPalindromicSubsequence(String s) {
  int n = s.length();
        int[][] charPositions = new int[26][2];
        
        // Initialize first and last occurrence of each character to -1
        for (int[] positions : charPositions) {
            Arrays.fill(positions, -1);
        }
        
        // Record the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (charPositions[c][0] == -1) {
                charPositions[c][0] = i; // First occurrence
            }
            charPositions[c][1] = i; // Last occurrence
        }
        
        // Count unique palindromic subsequences
        int result = 0;
        for (int c = 0; c < 26; c++) {
            int first = charPositions[c][0];
            int last = charPositions[c][1];
            
            if (first != -1 && first < last) {
                // Find unique characters between first and last occurrence
                boolean[] seen = new boolean[26];
                for (int i = first + 1; i < last; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                
                // Count unique middle characters
                for (boolean exists : seen) {
                    if (exists) {
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
}