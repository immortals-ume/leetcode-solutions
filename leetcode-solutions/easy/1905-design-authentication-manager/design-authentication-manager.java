class AuthenticationManager {

      private final int timeToLive;
    private final Map<String, Integer> tokenExpiry;
    private final PriorityQueue<Pair> minHeap;

    private static class Pair {
        String tokenId;
        int expiryTime;

        Pair(String tokenId, int expiryTime) {
            this.tokenId = tokenId;
            this.expiryTime = expiryTime;
        }
    }

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenExpiry = new HashMap<>();
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.expiryTime));
    }

    public void generate(String tokenId, int currentTime) {
        int expiry = currentTime + timeToLive;
        tokenExpiry.put(tokenId, expiry);
        minHeap.offer(new Pair(tokenId, expiry));
    }

    public void renew(String tokenId, int currentTime) {
        if (tokenExpiry.containsKey(tokenId) && tokenExpiry.get(tokenId) > currentTime) {
            int newExpiry = currentTime + timeToLive;
            tokenExpiry.put(tokenId, newExpiry);
            minHeap.offer(new Pair(tokenId, newExpiry));
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        // Cleanup expired tokens from the heap
        while (!minHeap.isEmpty() && minHeap.peek().expiryTime <= currentTime) {
            Pair expired = minHeap.poll();
            // Only remove from map if this is the latest expiry
            if (tokenExpiry.getOrDefault(expired.tokenId, 0) == expired.expiryTime) {
                tokenExpiry.remove(expired.tokenId);
            }
        }
        return tokenExpiry.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */