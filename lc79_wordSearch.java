class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        //traverse board, when encounter 'A', start search next char in word
        
        //search function return boolean
        
        //dfs
        
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, 0, i, j, word))
                    return true;
            }
        }
        return false;
    }
    
    
    public boolean dfs(char[][] board, int index, int i, int j, String word) {
        if (index == word.length())
            return true;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        
        visited[i][j] = true;
        
        if ( dfs(board, index + 1, i - 1, j, word) ||
               dfs(board, index + 1, i + 1, j, word) ||
               dfs(board, index + 1, i, j + 1, word) ||
               dfs(board, index + 1, i, j - 1, word) )
            return true;
        visited[i][j] = false;
        return false;
        
    }
}