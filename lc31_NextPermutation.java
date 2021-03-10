//https://www.youtube.com/watch?v=IbcQOdtmvpA
class Solution {
    public void nextPermutation(int[] nums) {
        
        
        int n = nums.length - 1;
        int i = n - 1;
        
        while ( i >= 0 && nums[i] >= nums[i + 1]) {
            //find the first decreased index from back
            i--;
        }
        
        if (i >= 0) {
            int j = n;
            //find first num greater than nums[i]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        
        while (i < j) {
            swap(nums, i, j);
            i++; 
            j--;
        }
    }
}