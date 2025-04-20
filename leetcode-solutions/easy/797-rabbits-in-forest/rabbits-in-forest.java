class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;

        // Count occurrences of each answer
        for (int answer : answers) {
            count.put(answer, count.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int k = entry.getKey();      // Each rabbit says there are 'k' others like them
            int v = entry.getValue();    // Number of rabbits who said 'k'

            int groupSize = k + 1;
            int groups = (v + groupSize - 1) / groupSize; // Ceiling division
            res += groups * groupSize;
        }

        return res;
    }
}