class Solution {
    public int shortestDistance(int[][] grid) {
        /*
        BFS
        loop grid, when find 1, start BFS, add distance on grid == 0, mark visited for each BFS
        record how many buildings can be reached for position == 0, need compare if it can
        reach all buildings
        
        **/
        if (grid == null || grid.length == 0) return -1;
        
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] canreachones = new int[m][n];
        int totalBuilding = 0;
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //start BFS
                    totalBuilding++;
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    int step = 1;
                    boolean[][] visited = new boolean[m][n];
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int d = 0; d < size; d++) {
                            int[] cur = queue.poll();
                            
                            for (int[] dir : directions) {
                                //new position
                                int row = cur[0] + dir[0];
                                int col = cur[1] + dir[1];
                                
                                if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 0
                                   || visited[row][col]) continue;
                                
                                visited[row][col] = true;
                                distance[row][col] += step;
                                canreachones[row][col]++;
                                queue.offer(new int[] {row, col});
                    
                            }
                            
                        }
                        step++;
                    }
                }
            }
        }
        
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && canreachones[i][j] == totalBuilding) {
                    minDis = Math.min(minDis, distance[i][j]);
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}