class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
// Traverse through `s` and `t`
        while (i <  s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        
        // The number of characters in `t` that haven't been matched
        int val=t.length()-j;
        return val>0?val:0;
    }
}