class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColors = new HashMap<>(); // Ball index -> color
        Map<Integer, Integer> colorFrequency = new HashMap<>(); // Color -> count
        Set<Integer> distinctColors = new HashSet<>(); // Unique colors
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                colorFrequency.put(oldColor, colorFrequency.get(oldColor) - 1);
                if (colorFrequency.get(oldColor) == 0) {
                    distinctColors.remove(oldColor);
                }
            }

            ballColors.put(ball, color);
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            result[i] = distinctColors.size();
        }

        return result;
    }
}