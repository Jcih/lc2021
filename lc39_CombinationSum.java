class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        /*
        
        sort candidates
        backtrack
        res, 0, cur, target
        
        **/
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, new ArrayList<>(), target, candidates);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int index, List<Integer> cur, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(res, i, cur, target - candidates[i], candidates);
            cur.remove(cur.size() - 1);
        }
        
    }
}