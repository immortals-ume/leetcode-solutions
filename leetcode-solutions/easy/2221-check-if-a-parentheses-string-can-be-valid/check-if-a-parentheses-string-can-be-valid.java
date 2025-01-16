class Solution {
    public boolean canBeValid(String s, String locked) {
         // If the length of s is odd, it's impossible to balance the parentheses
        if (s.length() % 2 != 0) {
            return false;
        }
        
        // Forward pass
        int balance = 0, flexible = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                flexible++;
            } else if (s.charAt(i) == '(') {
                balance++;
            } else { // s[i] == ')'
                balance--;
            }
            // If balance is negative, use a flexible character to balance
            if (balance < 0) {
                if (flexible > 0) {
                    flexible--;
                    balance++;
                } else {
                    return false;
                }
            }
        }

        // Backward pass
        balance = 0;
        flexible = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                flexible++;
            } else if (s.charAt(i) == ')') {
                balance++;
            } else { // s[i] == '('
                balance--;
            }
            // If balance is negative, use a flexible character to balance
            if (balance < 0) {
                if (flexible > 0) {
                    flexible--;
                    balance++;
                } else {
                    return false;
                }
            }
        }

        // If both passes succeeded, the string can be made valid
        return true;
    }
}