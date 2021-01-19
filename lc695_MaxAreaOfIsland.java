//Time O(Row * Col), Space O(row * col)

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //use dfs, when encounter 1, area = 1, dfs 4-dirs, change 1 to 0
        //dfs() return the sum of area,
        //int dfs(grid, i, j, visited)
        //res = Math.max(res, dfs());
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(res, dfs(grid, i , j, visited));
                }
            }
        }
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] ||
           grid[i][j] == 0) return 0;
        
        visited[i][j] = true;
        grid[i][j] = 0;

        return  1 + dfs(grid, i - 1, j, visited) +
                dfs(grid, i + 1, j, visited) +
                dfs(grid, i, j - 1, visited) +
                dfs(grid, i, j + 1, visited);
        
    }
}