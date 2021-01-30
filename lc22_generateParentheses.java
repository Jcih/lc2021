class Solution {
    public List<String> generateParenthesis(int n) {
        /*
        1. example
        2. data structure
        3. logic
        4. logic
        5. analysis
        =================
        using backtrack to generate the string
        first add "(" 
            resursively add "("  
        **/
        
        List<String> res = new ArrayList<>();
        
        helper(res, 0, 0, "", n);
        return res;
    }
    
    public void helper(List<String> res, int open, int close, String cur, int n) {
        if (cur.length() == 2 * n) {
            res.add(cur);
            return;
        }
        if (open < n) helper(res, open + 1, close, cur + "(", n);
        if (close < open) helper(res, open, close + 1, cur + ")", n);
    }
}