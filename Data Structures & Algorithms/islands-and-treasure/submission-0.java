class Solution {
    private static int INF = Integer.MAX_VALUE;
    private static int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        // Start from each treasure, to all neighbouring land pieces. update distances when reached

        if (grid == null || grid.length == 0) return;

        Queue<int[]> cells = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    cells.offer(new int[]{i, j});
                }
            }
        }

        while (!cells.isEmpty()) {
            int[] cell = cells.poll();
            int i = cell[0], j = cell[1];
            // Treasure cell or known land cell reachable from treasure cell
            for (int[] dir: dirs) {
                int x = i + dir[0], y = j + dir[1];
                // if (isValid(grid, x, y) && grid[x][y] != 0) {
                //     // Land cell
                //     if (1 + grid[i][j] < grid[x][y]) {
                //         // (x, y) reachable in faster time
                //         grid[x][y] = 1 + grid[i][j];
                //         cells.offer(new int[]{x, y});
                //     }
                // }
                // Optimized
                if (isValid(grid, x, y) && grid[x][y] == INF) {
                    grid[x][y] = grid[i][j] + 1;
                    cells.offer(new int[]{x, y});
                }
            }
        }
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
