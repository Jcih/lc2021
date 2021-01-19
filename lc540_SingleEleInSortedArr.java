// O(n) time, O(1) space
class Solution {
    public int singleNonDuplicate(int[] nums) {
    	//use XOR to get the single element
        
        int res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}