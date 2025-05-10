class TopVotedCandidate {

      private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];
        
        Map<Integer, Integer> voteCount = new HashMap<>();
        int currentLeader = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            voteCount.put(p, voteCount.getOrDefault(p, 0) + 1);

            if (voteCount.get(p) >= maxVotes) {
                if (p != currentLeader) {
                    currentLeader = p;
                }
                maxVotes = voteCount.get(p);
            }

            leaders[i] = currentLeader;
        }
    }

    public int q(int t) {
        int low = 0, high = times.length - 1;

        // Binary search to find the last time <= t
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (times[mid] <= t) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return leaders[low];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */