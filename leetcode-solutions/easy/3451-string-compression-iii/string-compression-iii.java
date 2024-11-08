class Solution {
    public String compressedString(String word) {
       StringBuilder comp = new StringBuilder();
        int n = word.length();
        int i = 0; // Index to iterate through the string

        while (i < n) {
            char currentChar = word.charAt(i);
            int count = 0;

            // Count consecutive characters up to 9 times
            while (i < n && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }

            // Append the count and the character to the compressed result
            comp.append(count).append(currentChar);
        }

        return comp.toString(); 
    }
}