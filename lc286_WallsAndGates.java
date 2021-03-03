class Solution {
    public void wallsAndGates(int[][] rooms) {
        /*
        BFS
        start from gate, push the gate position to queue
        BFS all neibours and update their value by add 1 each loop
        **/
        int[][] directions =  new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int row = rooms.length, col = rooms[0].length; 
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int cur_r = gate[0], cur_c = gate[1];
            
            //BFS 4 directions
            for (int[] dir : directions) {
                int next_r = cur_r + dir[0];
                int next_c = cur_c + dir[1];
                if (next_r < 0 || next_r >= row || next_c < 0 || next_c >= col ||
                    rooms[next_r][next_c] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[next_r][next_c] = Math.min(rooms[cur_r][cur_c] + 1, rooms[next_r][next_c]);
                queue.offer(new int[] {next_r, next_c});
                
            }
        }
        
        
    }
}