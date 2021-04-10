class Solution {
    public int maximumMinimumPath(int[][] A) {
        /*BFS + PriorityQueue
        visited Set for dedup
        priorityQueue<int> store (x, y, min) 
        
        
        **/
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int row = A.length, col = A[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.offer(new int[] {0, 0, A[0][0]});
        
        
        boolean[][] visited = new boolean[row][col];
        
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            
            int[] cur = pq.poll();
            int cur_row = cur[0];
            int cur_col = cur[1];

            if (cur_row == row - 1 && cur_col == col - 1) {
                return cur[2];
            }
            visited[cur_row][cur_col] = true;;

            for (int[] dir : dirs) {
                int x = cur_row + dir[0];
                int y = cur_col + dir[1];
                if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y])
                    continue;
                pq.offer(new int[] {x, y, Math.min(cur[2], A[x][y])});
            }
   
        }
        return -1;
    }
}