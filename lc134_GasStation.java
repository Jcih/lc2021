class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
          1. test
          2. data structure: for loop to check if the current is left is enough
          3. logics
          4. result
          5. analysis
          
          ==========================
          1 < 3
          2 < 4
          3 < 5
          4 > 1, 3 left
          3 + 5 = 8 > 2, 6 left
          6 + 1 = 7 > 3, 4 left
          4 + 2 = 6 > 4, 2 left
          2 + 3 = 5 >= 5, 0 left
          ===========================
          If we do have more fuel provided than costed, 
          that means we can always find a start point around this circle 
          that we could complete the journey with an empty tank. 
          ===========================
          Time:   Space: O(1)
          O(n)
        */
        
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return -1;
        
        int left = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int cur = left + gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                left = 0;
            } else {
                left = cur;
            }
        }
        return start;
    }
}