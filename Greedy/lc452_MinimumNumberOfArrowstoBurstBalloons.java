//greedy, intervals
class Solution {
    public int findMinArrowShots(int[][] points) {
        
        if (points == null || points.length == 0) return 0;
        //sort the point according to the end in ascending order,
        //count overlappings as a group, result is number of non overlapping groups
        //if non overlap, update prev marker.
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int res = 1;
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prev) {
                res++;
                prev = points[i][1];
            }
                 
        }
        return res;
    }
}