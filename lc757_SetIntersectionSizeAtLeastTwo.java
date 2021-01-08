//Hard, Uber
/*
sort the intervals according to the second element in ascending order
if two intervals have same second element, sort according to the first element in descending order

set left, right as the tracker of cur intersection elements in S, if the interval has no left and right included,
update left and right to the new values, res + 2; if right in interval, res + 1, and update left as right , update right 
to the latest vlaue (second element in the interval). 

*/

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) return res;
        
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        
        int left = intervals[0][1] - 1;
        int right = intervals[0][1];
        res = 2;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                res += 2;
                left = intervals[i][1] - 1;
                right = intervals[i][1];
            } else if (left < intervals[i][0] && intervals[i][0] <= right) {
                res++;
                left = right;
                right = intervals[i][1];
            }
        }
        return res;
    }
}