class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
         // Sort the deck to get the order in which cards should be revealed
        Arrays.sort(deck);
        
        // Initialize a queue to simulate the deck
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        
        // Initialize the result array
        int[] result = new int[deck.length];
        
        // Perform the simulation
        for (int card : deck) {
            // Revealing the card by placing it at the next available position in the result array
            result[queue.pollFirst()] = card;
            // Moving the next top card to the bottom of the deck if there are still unrevealed cards
            if (!queue.isEmpty()) {
                queue.add(queue.pollFirst());
            }
        }
        
        return result;
    }
}