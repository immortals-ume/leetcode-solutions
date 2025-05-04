class StreamChecker {

 private class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    private final TrieNode root = new TrieNode();
    private final Deque<Character> stream = new ArrayDeque<>();
    private final int maxWordLength;

    public StreamChecker(String[] words) {
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
            insert(word);
        }
        this.maxWordLength = maxLen;
    }

    private void insert(String word) {
        TrieNode node = root;
        // Insert the word in reverse
        for (int i = word.length() - 1; i >= 0; i--) {
            node = node.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        node.isWord = true;
    }

    public boolean query(char letter) {
        stream.addFirst(letter);
        if (stream.size() > maxWordLength) {
            stream.removeLast();
        }

        TrieNode node = root;
        for (char ch : stream) {
            node = node.children.get(ch);
            if (node == null) return false;
            if (node.isWord) return true;
        }

        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */