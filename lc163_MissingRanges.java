class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        /*
        1. compare the lower with the nums[0]
        
        2. compare inside nums
        
        3. compare the upper with the nums
        
        
        **/
        
        
        List<String> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            res.add(buildRange(lower, upper));
            return res;
        }
        
        
        if (lower < nums[0]) {
            res.add(buildRange(lower, nums[0] - 1));
        }
        
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1)
                res.add(buildRange(nums[i] + 1, nums[i + 1] - 1));
        }
        
        if (nums[nums.length - 1] < upper) {
            res.add(buildRange(nums[nums.length - 1] + 1, upper));
        }
        
        return res;
    }
    
    private String buildRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}