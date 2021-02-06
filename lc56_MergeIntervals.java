//intervals
//252 Meeting Rooms
//253 Meeting Rooms II
//452 Minimum Number of Arrows to Burst Balloons
//986 Interval List Intersections
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] prev = intervals[0];
        List<int[]> res = new ArrayList<>();
        
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (start <= prev[1]) {
                prev[1] = Math.max(prev[1], end);
            } else {
                res.add(prev);
                prev = intervals[i];
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][2]);
    }
}