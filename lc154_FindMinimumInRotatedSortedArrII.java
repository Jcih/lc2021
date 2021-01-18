class Solution {
    public int findMin(int[] nums) {
      //https://leetcode.com/explore/learn/card/binary-search/126/template-ii/937/
        //advanced binary search template
        
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //prevent the numeric overflow issue, since the sum of two integers could exceed the limit of the integer number.
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                //min in right side
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // min in left side
                right = mid;
            } else {
                right--;
            }
        }
        // End Condition: left > right
 
        return nums[left];
    }
}