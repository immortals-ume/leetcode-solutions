class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
           int n = s.length();
        int[] diff = new int[n + 1]; // Difference array
        
        // Apply the shifts to the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            if (direction == 1) {
                diff[start] += 1;
                diff[end + 1] -= 1;
            } else {
                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }
        
        // Compute the prefix sum to get net shifts at each position
        int[] netShifts = new int[n];
        int shift = 0;
        for (int i = 0; i < n; i++) {
            shift += diff[i];
            netShifts[i] = shift;
        }
        
        // Build the result string by applying the shifts
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int shiftAmount = (netShifts[i] % 26 + 26) % 26; // Handle wrapping
            char newChar = (char) ((s.charAt(i) - 'a' + shiftAmount) % 26 + 'a');
            result.append(newChar);
        }
        
        return result.toString();
    }
}