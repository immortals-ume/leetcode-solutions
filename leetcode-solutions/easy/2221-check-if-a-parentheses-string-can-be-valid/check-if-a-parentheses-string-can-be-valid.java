class Solution {
    public boolean canBeValid(String s, String locked) {
     // A valid parentheses string must have even length
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> flexibleStack = new Stack<>();

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0') {
                // Flexible character, push its index onto the flexible stack
                flexibleStack.push(i);
            } else if (c == '(') {
                // Fixed '(', push its index onto the open stack
                openStack.push(i);
            } else { // c == ')'
                if (!openStack.isEmpty()) {
                    // Use a fixed '(' to balance this ')'
                    openStack.pop();
                } else if (!flexibleStack.isEmpty()) {
                    // Use a flexible character to balance this ')'
                    flexibleStack.pop();
                } else {
                    // No matching '(' or flexible character available
                    return false;
                }
            }
        }

        // Handle remaining unmatched '('
        while (!openStack.isEmpty() && !flexibleStack.isEmpty()) {
            // Ensure flexible indices can balance open indices
            if (flexibleStack.pop() < openStack.pop()) {
                return false; // Invalid if flexible cannot match an open parenthesis
            }
        }

        // Return true if all '(' are matched; otherwise, false
        return openStack.isEmpty();
    }
}