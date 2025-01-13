class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Step 1: Compute the maximum frequency for each character in words2
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] wordFreq = countFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], wordFreq[i]);
            }
        }

        // Step 2: Filter words1 based on maxFreq
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] wordFreq = countFrequency(word);
            if (isUniversal(wordFreq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper method to count character frequencies in a word
    private int[] countFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper method to check if a word satisfies the universal condition
    private boolean isUniversal(int[] wordFreq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}