class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         /*
         map of freq: 1: 3,2, 2, 3, 1
         
         PriorityQueue 
         **/
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        
        for (int key : freq.keySet()) {
            pq.offer(key);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int n = pq.size() - 1;
        int[] res = new int[n + 1];
        while (!pq.isEmpty()) {
            res[n--] = pq.poll();
        }
        return res;
    }
}