class Solution {
    private static int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        // BFS approach. Process fruits that will expire in the next minute first
        Queue<int[]> rotten = new ArrayDeque<>();
        int fruitsCount = 0;
        for (int i=0; i< grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fruitsCount++;
                }
                if (grid[i][j] == 2) {
                    // Initial set of rotten fruits
                    rotten.offer(new int[] {i, j});
                }
            }
        }
        int timeElapsed = 0;
        while (!rotten.isEmpty()) {
            if (fruitsCount == 0) {
                return timeElapsed;
            }
            // Process all rotten fruits in this time cycle
            for (int items = rotten.size(); items > 0; items--) {
                int[] cell = rotten.poll();

                for (int[] dir: dirs) {
                    int x = cell[0] + dir[0], y = cell[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                        if (grid[x][y] == 1) {
                            fruitsCount--;
                            grid[x][y] = 2;
                            rotten.offer(new int[] {x, y});
                        }
                    }
                }
            }
            timeElapsed++;
        }
        return fruitsCount == 0? timeElapsed: -1;
    }
}
