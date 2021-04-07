class Solution {
    
    int[][] moves = new int[][] {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
    public int minKnightMoves(int x, int y) {
        
        // abs(x), abs(y) has the same result of (x, y)
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int step = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                if (curPos[0] == x && curPos[1] == y)
                    return step;
                
                for (int[] move : moves) {
                    int[] newPos = new int[] {curPos[0] + move[0], curPos[1] + move[1]};
                    String newPosStr = newPos[0] + "," + newPos[1];
                    if (visited.contains(newPosStr) || newPos[0]  < -1 || newPos[1] < -1)
                        continue;
                    queue.add(newPos);
                    visited.add(newPosStr);
                }
            }
            step++;
        }
        return step;
        
        
        
    }
}