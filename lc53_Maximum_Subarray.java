class Solution {
    public int maxSubArray(int[] nums) {
        /*
        each step, update local sum_max and global sum_max
        
        
        **/
        
        int[] local_max = new int[nums.length];
        int global_max = nums[0];
        local_max[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            local_max[i] = Math.max(local_max[i - 1] + nums[i], nums[i]);
            global_max = Math.max(global_max, local_max[i]);
        }
        return global_max;
                            
    }
}