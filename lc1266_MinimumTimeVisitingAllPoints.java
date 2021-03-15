class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        /*
        move diagonally as many as possible
        
        Math.min(diff_x, diff_y) is the number of move diagonally
        
        abs(diff_x - diff_y) is the number of move vertivcally or horizontally between two points
        after thet move diagonally
        
        
        **/
        if (points == null || points.length == 0) return 0;
        
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int diff_x = Math.abs(points[i + 1][0] - points[i][0]);
            int diff_y = Math.abs(points[i + 1][1] - points[i][1]);
            res += Math.min(diff_x, diff_y) + Math.abs(diff_x - diff_y);
        }
        return res;
    }
}