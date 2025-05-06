class NeighborSum {

    private final int[][] grid;
    private final Map<Integer, int[]> valueToPosition;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.valueToPosition = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                valueToPosition.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        int[] pos = valueToPosition.get(value);
        int i = pos[0], j = pos[1];
        int sum = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (isInBounds(ni, nj)) {
                sum += grid[ni][nj];
            }
        }
        return sum;
    }

    public int diagonalSum(int value) {
        int[] pos = valueToPosition.get(value);
        int i = pos[0], j = pos[1];
        int sum = 0;
        int[][] diagonals = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // top-left, top-right, bottom-left, bottom-right

        for (int[] dir : diagonals) {
            int ni = i + dir[0], nj = j + dir[1];
            if (isInBounds(ni, nj)) {
                sum += grid[ni][nj];
            }
        }
        return sum;
    }

    private boolean isInBounds(int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */