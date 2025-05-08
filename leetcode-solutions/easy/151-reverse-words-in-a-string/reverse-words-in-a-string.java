class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        // Reverse the order of the words
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        // Join the reversed words with a single space and return the result
        return String.join(" ", words); 
    }
}