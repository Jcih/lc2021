//similiar with String compress , lc 443
class Solution {
    public int minCost(String s, int[] cost) {
        /*
        
        loop the s, another pointer j to count sum and get the max
        for the same char, add the value (sum - max) to res
        
        
        **/
        
        int res = 0;
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            int sum = 0;
            int maxCost = 0;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                maxCost = Math.max(maxCost, cost[j]);
                sum += cost[j];
                j++;
            }
            
            res += sum - maxCost;
            i = j;
        }
        return res;
    }
}