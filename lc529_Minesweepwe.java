//DFS, Uber

class Solution {
    
    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1},{0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return board;
        
        int row = click[0], col = click[1];
        char clicked = board[row][col];
        
        if (clicked == 'M') {
            //over
            board[row][col] = 'X';
        } else if (clicked == 'E') {
            updateDFS(board, row, col);
        }
        return board;
    }
    
    private void updateDFS(char[][] board, int x, int y) {
        //consider boundaries
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') return;
        
        int adjMines = cntMines(board, x, y);
        
        if (adjMines > 0) {
            board[x][y] = (char) (adjMines + '0');
        } else {
            for (int[] dir : dirs) {
                board[x][y] = 'B';
                updateDFS(board, x + dir[0], y + dir[1]);
            }
        }
    }
    
    private int cntMines(char[][] board, int x, int y) {
        int count = 0;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int row = x + i;
                int col = y + j;
                //consider boundaries
                if (row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] == 'M') count++;
            }
        }
        return count;
    }
}