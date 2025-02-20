class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (isValidPartition(String.valueOf(square), 0, i)) {
                sum += square;
            }
        }

        return sum;
    }

    // Backtracking function to check partitioning condition
    private boolean isValidPartition(String s, int index, int target) {
        if (index == s.length()) {
            return target == 0; // If target is fully reduced to 0, valid partition found
        }

        int num = 0;
        for (int j = index; j < s.length(); j++) {
            num = num * 10 + (s.charAt(j) - '0'); // Forming number from substring

            if (num > target) break; // Stop if num exceeds target

            if (isValidPartition(s, j + 1, target - num)) {
                return true; // Found a valid partition
            }
        }
        return false;
    }
}