class Solution {
    private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;

        int maxArea = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, getArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int i, int j) {
        // Out of bounds, water or previously visited land cell
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        // Mark visited
        grid[i][j] = 2;
        int currentArea = 1;
        for (int[] dir: DIRS) {
            currentArea += getArea(grid, i + dir[0], j + dir[1]);
        }
        return currentArea;
    }
}
