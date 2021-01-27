class Solution {
    public int shipWithinDays(int[] weights, int D) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ====================
        min = 10 weights ,, most days : weights.length
        max = sum[weights],, least days 1
        binary search 
        ====================
        
        **/
        
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            //try mid capacity
            int daysNeeded = 1;
            int cur = 0;
            for (int w : weights) {
                
                if (cur + w > mid) {
                    daysNeeded++;
                    cur = 0;
                }
                cur += w;
            }
            
            if (daysNeeded > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}