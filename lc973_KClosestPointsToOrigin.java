class Solution {
    public int[][] kClosest(int[][] points, int K) {
        /*
        1. exmaple
        2. data structure
        3. logic
        4. result
        5. analysis
        ==============
        use priorityQueue where (a, b)-> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        if pq.size() >= k
           pq.poll();// the smallest left
        
        Space: O(N) to build a heap 
        Time: O(Klog(N)) to extract.
        */   
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        for (int[] point : points) {
            pq.offer(point);
            
            if (pq.size() > K)
                pq.poll();     
        }
        
        int[][] res = new int[K][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
}