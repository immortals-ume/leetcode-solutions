class Solution {
    public String makeFancyString(String s) {
         StringBuilder result = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // Append the character if the last two characters in result are not the same as s.charAt(i)
            int len = result.length();
            if (len < 2 || !(result.charAt(len - 1) == s.charAt(i) && result.charAt(len - 2) == s.charAt(i))) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}