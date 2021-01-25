class Solution {
    public int minMeetingRooms(int[][] intervals) {
        /**
        1. examples
        2. data structure, algo 
            sort according to the first element (start time)
            use PriorityQueue to record the rooms that can be released and allocated (end time)
        3. logics
        4. result
        5. analysis
        ==========================
        [0, 30], [5, 10], [15, 20]
        1        1
        
        [2, 4]. [7, 10]
        1
        =======================
        

        */
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//O(nlogn)
        PriorityQueue<Integer> pq = new PriorityQueue<>();//O(logn)
        pq.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < pq.peek()) {
                pq.add(intervals[i][1]);
            } else {
                //can use the same roome, update the end time
                pq.poll();
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}