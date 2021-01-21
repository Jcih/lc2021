class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(res, 1, new ArrayList<>(), n , k);
        
        return res;
    }
    
    public void helper(List<List<Integer>> res, int index, List<Integer> cur, int n, int k) {
        
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        
        for (int i = index; i <= n; i++) {
            cur.add(i);
            helper(res, i + 1, cur, n, k);
            cur.remove(cur.size() - 1);
        }
        
    }
}