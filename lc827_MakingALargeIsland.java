class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    int id = 2;
    int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1},
    };
    public int largestIsland(int[][] grid) {
        /*
        if grid has 0. mark 0 as 1, and do dfs  like number of island
        if no zero, return n * n
        **/
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, id);
                    map.put(id, area);
                    res = Math.max(res, area);
                   
                   id += 1;
                }
                
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, connectedIslands(grid, i, j) + 1);
                }
            }
        }
        
        return res;
 
    }
    
    
    private int connectedIslands(int[][] grid, int row, int col) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for(int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            
            if (x < 0 || y < 0 || x >= grid.length || y >= grid.length ||
            visited.contains(grid[x][y]) || grid[x][y] <= 1) continue;
            
            count += map.get(grid[x][y]);
            visited.add(grid[x][y]);
   
        }
        return count;
  
    }
    
    // mark the island as id
    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) return 0;
        
         grid[i][j] = id;
        
        int res = 1 + dfs(grid, i + 1, j, id) + dfs(grid, i - 1, j, id) + dfs(grid, i, j + 1, id) + dfs(grid, i, j - 1, id);
        return res;
    }
}