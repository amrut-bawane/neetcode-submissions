class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 'x';
                    dfs(grid, i, j);
                }
            }
        }
        int islands = 0;
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 'x') {
                    islands++;
                }
            }
        }
        return islands;
    }

    // Traverse all directions from land at (i, j) & connect them (Mark 'o' assimilate)
    private void dfs(char[][] grid, int i, int j) {
        int[][] neighbours = new int[][] {{i, j-1}, {i, j+1}, {i-1, j}, {i+1, j}};
        for (int[] coordinate: neighbours) {
            int x = coordinate[0];
            int y = coordinate[1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                if (grid[x][y] == '1') {
                    // Neighbor is an unvisited piece of land. Include in current island
                    grid[x][y] = 'o';
                    dfs(grid, x, y);
                }
            }
        }
    }
}
