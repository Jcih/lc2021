class Solution {
    public int maxProfit(int[] prices) {
        
        /*
        add the first transaction's profit to the second transaction
        
        **/
        
        int t1min = Integer.MAX_VALUE, t2min = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;
        
        for (int price : prices) {
            t1min = Math.min(t1min, price);
            t1Profit = Math.max(t1Profit, price - t1min);
            
            t2min = Math.min(t2min, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2min);
        }
        return t2Profit;
    }
}