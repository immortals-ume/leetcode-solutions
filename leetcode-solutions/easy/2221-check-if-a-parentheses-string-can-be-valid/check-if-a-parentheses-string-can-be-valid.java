class Solution {
    public boolean canBeValid(String s, String locked) {
  // A valid parentheses string must have even length
        if (s.length() % 2 != 0) {
            return false;
        }

        // Forward pass: Check if valid left-to-right
        int minOpen = 0, maxOpen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0') {
                // Flexible character: Could be '(' or ')'
                minOpen = Math.max(0, minOpen - 1);
                maxOpen++;
            } else if (c == '(') {
                // Fixed '('
                minOpen++;
                maxOpen++;
            } else { // c == ')'
                // Fixed ')'
                minOpen = Math.max(0, minOpen - 1);
                maxOpen--;
            }
            // If maxOpen < 0, too many unmatched ')'
            if (maxOpen < 0) {
                return false;
            }
        }

        // If minOpen > 0 after forward pass, it's invalid
        return minOpen == 0;
    }
}