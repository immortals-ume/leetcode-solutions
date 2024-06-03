class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int sLen = s.length(), tLen = t.length();
        
        // Traverse through `s` and `t`
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        
        // The number of characters in `t` that haven't been matched
        return tLen - j;
    }
}