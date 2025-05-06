class AuthenticationManager {

       private final int timeToLive;
    private final Map<String, Integer> tokenExpiry;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenExpiry = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenExpiry.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokenExpiry.containsKey(tokenId) && tokenExpiry.get(tokenId) > currentTime) {
            tokenExpiry.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int expiryTime : tokenExpiry.values()) {
            if (expiryTime > currentTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */