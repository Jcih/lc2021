class Solution {
    public int[] sortedSquares(int[] nums) {
        
        /*
        
        two pointers 
        i = 0, j = nums.length - 1
        nums[i] decrease
        nums[j] decrease
        
        merge
        
        **/
        
        int[] res = new int[nums.length];
        int n = nums.length;
        
        int left = 0, right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int picked;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                picked = nums[left];
                left++;
            } else {
                picked = nums[right];
                right--;
            }
            res[i] = picked * picked;
        }
        return res;
    }
}