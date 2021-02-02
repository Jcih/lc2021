class Solution {
    public int findPeakElement(int[] nums) {
        /*
        1. example
        2. data structure / algo
        3. logic
        4. result
        5. analysis
        ===========
        when i == 0 || i == nums.length - 1
        compare the one side
        if len >= 3
         compare two sides
        **/
        
        if (nums.length == 1) return 0;
        if (nums.length == 2) {
            if (nums[0] > nums[1])
                return 0;
            else {
                return 1;
            }
        }
        
        int res = -1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
                return i;     
        }
        if (res == -1) {
            if (nums[0] > nums[1]) {
                res = 0;
            } else {
                res = nums.length - 1;
            }
        }
        return res;
    }
}