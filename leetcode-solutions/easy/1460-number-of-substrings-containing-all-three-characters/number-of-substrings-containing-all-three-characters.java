class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = { -1, -1, -1 }; // Track last seen index of 'a', 'b', 'c'
        int result = 0;
        
        for (int r = 0; r < s.length(); r++) {
            lastSeen[s.charAt(r) - 'a'] = r; // Update last seen index
            
            // Smallest last seen index gives the earliest valid starting position
            int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            result += (minIndex + 1); // Count substrings ending at r
        }
        
        return result;
    }
}