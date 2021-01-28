class Solution {
    public int maxProfit(int[] prices) {
        
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        =================
        only think increse cases:
        1 5 3 1 : 5 - 1 = 4
        1 5 6 : 5 - 1 + (6 - 5) = 5
        =================
        take every increse pair
        =================
        Time O(n)
        **/
        if (prices == null || prices.length <= 1) return 0;
        
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    
}