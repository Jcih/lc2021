class Solution {
    public boolean search(int[] nums, int target) {
        //[1,2,3,4,5,6] -> [5,6,1,2,3,4], [3,4,5,6,1,2]
        //if (nums[mid] > nums[left]), left half is incresing
        //else right half is increasing
        
        //when left is increasing, need to check if target in left: nums[0] < target < num[mid]
        //when right is increasing, need to check if target is in right : num[mid] < target < num[right]
        
        //what need think: why miss the case that nums[left] == nums[mid]
        //if (nums[mid] == nums[left]) left++;
        //what happened if nums[mid] == nums[left], means remove duplicate, use left++
        
        int left = 0;
        int right = nums.length - 1;
        if (nums == null || nums.length == 0) return false;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return true;
            
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                
            } else {
                left++;
            }
        }
        
        return false;
        
    }
}