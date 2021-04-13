class Solution {
    char[] signs = {'+', '-', '*'};
    public List<String> addOperators(String num, int target) {
        /**
        backtrack: each round will try *, + , -, and get the number == target
        
        **/
        List<String> res = new ArrayList<>();
        helper(res, "", num, target, 0, 0, 0);
        
        return res;
    }
    
    private void helper(List<String> res, String cur, String num, int target, int index, long sum, long last) {
        if (index == num.length() && sum == target) {
            res.add(new String(cur));
            return;
        }
        
        if (index >= num.length()) return;
        
        for (int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && i != index) break;
            long tmp = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(res, cur + tmp + "", num, target, i + 1, tmp, tmp);
            } else {
                helper(res, cur + "+" + tmp, num, target, i + 1, sum + tmp, tmp);
                helper(res, cur + "-" + tmp, num, target, i + 1, sum - tmp, -tmp);
                helper(res, cur + "*" + tmp, num, target, i + 1, sum - last + last * tmp, last * tmp);
            }
        }
        
        
    }
}