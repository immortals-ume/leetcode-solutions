class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        List<int[]> maxLocal = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            int[] rowMax = new int[n - 2];
            for (int j = 1; j < n - 1; j++) {
                int[] submatrix = { grid[i - 1][j - 1], grid[i - 1][j], grid[i - 1][j + 1],
                                    grid[i][j - 1],     grid[i][j],     grid[i][j + 1],
                                    grid[i + 1][j - 1], grid[i + 1][j], grid[i + 1][j + 1] };
                rowMax[j - 1] = findMax(submatrix);
            }
            maxLocal.add(rowMax);
        }

        int[][] result = new int[maxLocal.size()][maxLocal.get(0).length];
        for (int i = 0; i < maxLocal.size(); i++) {
            result[i] = maxLocal.get(i);
        }
        return result;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}