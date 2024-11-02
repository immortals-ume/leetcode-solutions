class Solution {
 // Node class for the circular linked list
    static class Node {
        String word;
        Node next;

        Node(String word) {
            this.word = word;
        }
    }

    // Method to check if the sentence is circular
    public static boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Create the circular linked list
        Node head = new Node(words[0]);
        Node current = head;
        for (int i = 1; i < words.length; i++) {
            current.next = new Node(words[i]);
            current = current.next;
        }
        // Link the last node to the head to form a circular structure
        current.next = head;

        // Traverse the circular linked list and check circular condition
        Node node = head;
        do {
            // Get the last character of the current word
            char lastChar = node.word.charAt(node.word.length() - 1);
            // Get the first character of the next word
            char firstChar = node.next.word.charAt(0);

            // Check if last character of the current word matches
            // the first character of the next word
            if (lastChar != firstChar) {
                return false;
            }

            node = node.next;
        } while (node != head); // Continue until we loop back to the head

        // If all checks passed, the sentence is circular
        return true;
    }
}