//greedy
class Solution {
    public boolean checkPossibility(int[] nums) {
        
        if (nums == null || nums.length <= 2) return true;
        
        int count = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count > 0) return false;
                if (i -2 >= 0 && i + 1 < nums.length && (nums[i] < nums[i - 2] && nums[i + 1] < nums[i - 1]))
                    return false;

                count++;
            }
            
        }
        return true;
    } 
}