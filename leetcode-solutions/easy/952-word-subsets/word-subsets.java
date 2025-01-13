class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
            // Step 1: Compute the maximum frequency for each character in words2
        Map<Character, Integer> maxFreq = new HashMap<>();
        for (String word : words2) {
            Map<Character, Integer> wordFreq = countFrequency(word);
            for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
                char c = entry.getKey();
                int freq = entry.getValue();
                maxFreq.put(c, Math.max(maxFreq.getOrDefault(c, 0), freq));
            }
        }

        // Step 2: Filter words1 based on maxFreq
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            Map<Character, Integer> wordFreq = countFrequency(word);
            if (isUniversal(wordFreq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper method to count character frequencies in a word using HashMap
    private Map<Character, Integer> countFrequency(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    // Helper method to check if a word satisfies the universal condition
    private boolean isUniversal(Map<Character, Integer> wordFreq, Map<Character, Integer> maxFreq) {
        for (Map.Entry<Character, Integer> entry : maxFreq.entrySet()) {
            char c = entry.getKey();
            int requiredFreq = entry.getValue();
            if (wordFreq.getOrDefault(c, 0) < requiredFreq) {
                return false;
            }
        }
        return true;
    }

}