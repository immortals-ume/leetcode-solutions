class Solution {
    public List<String> stringMatching(String[] words) {
           List<String> result = new ArrayList<>();
        int n = words.length;

        // Iterate through each word
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Stop checking once we find one match
                }
            }
        }

        return result;
    }
}