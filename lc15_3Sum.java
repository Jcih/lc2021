class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        sort
        for loop nums,
          in each iteration, need two pointer , start , end check if 3 nums sum == 0
        
        **/
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            while (start < end) {
                if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                
                if (nums[i] + nums[start] + nums[end] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    res.add(tmp);
                    start++;
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}