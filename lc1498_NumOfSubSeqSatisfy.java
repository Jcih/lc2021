class Solution {
    public int numSubseq(int[] nums, int target) {
        /*
        sort the araay to easilt find the max and min by left, and right

        **/

        Arrays.sort(nums);
        int res = 0;
        
        int left = 0, right = nums.length - 1;
        int mod = (int)1e9 + 7;
        int[] pow = new int[right + 1];
        pow[0] = 1;
        
        //from 0 to i, the number of permutaions
        for (int i = 1; i <= right; i++) {
            pow[i] = 2 * pow[i - 1] % mod;
        }
        
        
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + pow[right - left]) % mod;// from left to right, number of permutations
                left++;
            }
        }
        return res;
    }
}