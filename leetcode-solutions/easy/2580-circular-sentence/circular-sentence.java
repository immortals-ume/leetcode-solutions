class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Use a circular queue to process the words
        Queue<String> queue = new LinkedList<>();
        for (String word : words) {
            queue.offer(word);
        }

        // Check each word with the next one in a circular manner
        String firstWord = queue.peek(); // First word for final circular check
        String prevWord = queue.poll();  // Start with the first word in the queue

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            // Check if the last character of prevWord matches the first character of currentWord
            if (prevWord.charAt(prevWord.length() - 1) != currentWord.charAt(0)) {
                return false;
            }
            prevWord = currentWord;
        }

        // Final check: last character of the last word with the first character of the first word
        return prevWord.charAt(prevWord.length() - 1) == firstWord.charAt(0);
    }
}