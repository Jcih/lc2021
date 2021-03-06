class Solution {
    
    
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, - 1}, {0, 1}};
    
    public int islandPerimeter(int[][] grid) {
        /*
        DFS when ever meet a boundary (grid[i][j] == 0) edge++;
        
        **/
        
        if (grid == null || grid.length == 0) return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for ( int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }
    
    private int dfs(int i, int j, int[][] grid) {
        
        grid[i][j] = -1;
        
        int count = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
                count++;
            } else {
                if (grid[x][y] == 1) {
                    count += dfs(x, y, grid);
                }
            }
        }
        return count;
    }
    
}






class Solution {
    
    
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, - 1}, {0, 1}};
    
    public int islandPerimeter(int[][] grid) {
        /*
        BFS when ever meet a boundary (grid[i][j] == 0) edge++;
        
        **/
        int res = 0;
        
        if (grid == null || grid.length == 0) return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for ( int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0)
                            res++;
                    }
   
                }
            }
        }
        return res;
    }
}