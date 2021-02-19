//https://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/

//find the pivot position first. 

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) { // be careful about the =
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] >= nums[left]) {  // be careful about the = // 200717， missing "="
                //pivot is on right to mid
                
                if (nums[left] <= target && target < nums[mid]) { // be careful about the =
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                
            } else {
                //pivot is on left to mid
                if (nums[mid] < target && nums[right] >= target) { // be careful about the =
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}