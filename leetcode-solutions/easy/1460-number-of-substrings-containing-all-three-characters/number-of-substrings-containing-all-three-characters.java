class Solution {
    public int numberOfSubstrings(String s) {
                int[] count = new int[3]; // To store frequency of 'a', 'b', 'c'
        int l = 0, result = 0;
        
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']++; // Expand window
            
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) { // Valid substring
                result += s.length() - r; // Count all substrings starting at l
                count[s.charAt(l) - 'a']--; // Shrink window
                l++;
            }
        }
        
        return result;
    }
}