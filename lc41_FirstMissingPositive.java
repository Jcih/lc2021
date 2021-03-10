class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
        what we can notice : 
         0 1 2 3
        [1,2,3,4]
        
        position i should == i + 1
        ==> nums[i] == i + 1
        do something to make this happen , then we can get the result
        ====================
        
        memorize
        nums[nums[i] - 1] == nums[i] 
        
        **/
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                //swap nums[i] and nums[nums[i] - 1]
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}