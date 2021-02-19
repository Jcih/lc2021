//backtrack

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] nums, int index, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(res, nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}