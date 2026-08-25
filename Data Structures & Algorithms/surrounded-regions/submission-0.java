class Solution {
    private static int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
   
   public void solve(char[][] board) {
        // Step 1 - Find edges
        // Step 2 - Connect all edges to raechable 'Os' & mark them escaped
        // Step 3 - Mark remaining 'Os' as surrounded

        if (board == null || board[0].length == 0) return;

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                markConnectedAsEscaped(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                markConnectedAsEscaped(board, i, board[0].length - 1);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                markConnectedAsEscaped(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                markConnectedAsEscaped(board, board.length - 1, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void markConnectedAsEscaped(char[][] board, int i, int j) {
        board[i][j] = '1';
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y>=0 && x < board.length && y < board[0].length) {
                if (board[x][y] == 'O') {
                    markConnectedAsEscaped(board, x, y);
                }
            }
        }
    }
    
}
