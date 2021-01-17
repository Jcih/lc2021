class Solution {
    public int[] searchRange(int[] nums, int target) {
        //thoughts: binary search to find the target
        //when find the target, move left and right to get the first and last index
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int l = 0, r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int cur = nums[m];
            
            if (cur == target) {
                index = m;
                break;
            } else if (cur < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        if (index == -1) {
            res[0] = -1;
            res[1] = -1;
        } else {
            
            int first = index;
            int last = index;
            while (first >= 0 && nums[first] == target) first--;
            while (last < nums.length && nums[last] == target) last++;
            res[0] = first + 1;
            res[1] = last - 1;
        }
        return res;
    }
}