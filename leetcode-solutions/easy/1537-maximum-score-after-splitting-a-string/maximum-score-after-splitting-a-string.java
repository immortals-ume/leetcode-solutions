class Solution {
    public static int maxScore(String s) {
        int maxScore = 0;
        int zerosLeft = 0;
        int onesRight = countOnes(s); // Count the total number of ones in the string

        // Iterate through the string, excluding the last character
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosLeft++;
            } else {
                onesRight--;
            }

            // Calculate the current score and update the maximum score if needed
            int currentScore = zerosLeft + onesRight;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

    private static int countOnes(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}