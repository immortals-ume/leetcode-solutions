class Solution {
    public int[] minOperations(String boxes) {
          int n = boxes.length();
        int[] answer = new int[n];

        // Traverse left-to-right for prefix cost
        int count = 0; // Number of balls seen so far
        int cost = 0;  // Total cost to move balls to the current box
        for (int i = 0; i < n; i++) {
            answer[i] += cost;
            count += boxes.charAt(i) - '0'; // Add 1 if current box has a ball
            cost += count; // Add the number of balls to the cost
        }

        // Traverse right-to-left for suffix cost
        count = 0;
        cost = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += cost;
            count += boxes.charAt(i) - '0'; // Add 1 if current box has a ball
            cost += count; // Add the number of balls to the cost
        }

        return answer;
    }
}