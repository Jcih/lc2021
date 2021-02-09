class Solution {
    public int findKthLargest(int[] nums, int k) {
        /** O(nlogn)
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            k--;
            if (k == 0) return nums[i];
        }
        return -1;
        */
        
        //O(nlogk)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b); 
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}