//intervals, greedy , using sort
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        //sort the intervals according to the end element in asscending order
        //do we need to sort the first element? no need because [4, 5] [3, 5] only can 
        // keep one, which one doesn't matter, no impact on the result
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int res = 0, prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                res++;
            } else {
                prev = intervals[i][1];
            }
        }
        return res;
    }
}