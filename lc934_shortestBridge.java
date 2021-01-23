class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] A) {
        //dfs find the first island, push all 1 to queue
        // bfs, each loop, expand one step, until get the new 1 island
        
        int row = A.length, col = A[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        
        loop:
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) continue;
                if (A[i][j] == 1) {
                    //dfs add 1 points to Queue
                    dfs(A, i, j, visited, queue);
                    break loop;// break the whole loop
                }
            }
        }
        
        int step = 0;
        //bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                //expand one level
                for (int[] dir : directions) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if (i < 0 || i > row - 1 || j < 0 || j > col - 1 || visited[i][j])
                        continue;
                    if (A[i][j] == 1) {
                        return step;
                    }
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
                //size--;
            }
            step++;
        }
        return -1;
        
        
        
    }
    
    
    public void dfs(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> queue) {
        if (i < 0 || i > A.length - 1 || j < 0 || j > A[0].length - 1 || visited[i][j] || A[i][j] == 0)
            return;
        
        visited[i][j] = true;
        queue.add(new int[] {i, j});
        //four directions dfs
        
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(A, row, col, visited, queue);
        }  
    }
}