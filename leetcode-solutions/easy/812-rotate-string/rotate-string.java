class Solution {
    public boolean rotateString(String s, String goal) {
          // Step 1: Check if lengths are the same
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Step 2: Check if goal is a substring of s + s
        String concatenated = s + s;
        return concatenated.contains(goal);
    }
}