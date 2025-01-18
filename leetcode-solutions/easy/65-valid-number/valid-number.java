class Solution {
    public boolean isNumber(String s) {
           // Regex to match valid numbers
        String regex = "^[+-]?(" +                // Optional sign
                       "(\\d+\\.?\\d*)|" +       // Digits optionally followed by a dot and more digits (e.g., "123", "123.456")
                       "(\\.\\d+)" +            // Dot followed by digits (e.g., ".456")
                       ")" +
                       "([eE][+-]?\\d+)?$";     // Optional exponent part (e.g., "e10", "E-3")

        // Match the string against the regex
        return s.matches(regex);
    }
}