class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        for (int[] point : buildings) {
            buildLines.add(new int[] {point[0], -point[2]});
            buildLines.add(new int[] {point[1], point[2]});
        }
        
        Collections.sort(buildLines, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        pq.offer(0);
        int preHighest = 0;
        
        for (int[] points : buildLines) {
            if (points[1] < 0) {
                pq.add(-points[1]);
            } else {
                pq.remove(points[1]);
            }
            
            int curHeight = pq.peek();
            if (curHeight != preHighest) {
                res.add(Arrays.asList(points[0], curHeight));
                preHighest = curHeight;
            }
        }
        return res;
    }
}