class Solution {
    public int maxProfit(int[] prices) {
        /**
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ================
        
        min = 1, maxprofit = 3, 2, 5, 3, pick 5
        ================
        need a min price and a max profit
        
        one pass 
        Time O(N)
        Space O(1)
        */
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        
        return maxProfit;
    }
}