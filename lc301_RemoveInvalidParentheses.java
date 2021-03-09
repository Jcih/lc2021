//https://www.youtube.com/watch?v=-IbZA4WckOc&t=1s

class Solution {
    
    private int getMinParenToRemove(String s) {
        int minParenRemoveCount = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    minParenRemoveCount++;
                } else {
                    open--;
                }
            }
        }
        minParenRemoveCount += open;
        return minParenRemoveCount;
    }
    
    
    public List<String> removeInvalidParentheses(String s) {
        int minParenToRemove = getMinParenToRemove(s);
        Set<String> res = new HashSet<>();
        dfs(s, 0, minParenToRemove, 0, "", res);
        
        //convert set to list
        List<String> list = new ArrayList<>();
        for (String s1 : res) {
            list.add(s1);
        }
        return list;
    }
    
    private void dfs(String s, int index, int parenRemoveCount, int open, String tmp, Set<String> res) {
        if (index == s.length()) {
            if (parenRemoveCount == 0 && open == 0) {
                res.add(tmp);
            }
            return;
        }
        
        if (parenRemoveCount < 0) return;
        
        if (s.charAt(index) == '(') {
            dfs(s, index + 1, parenRemoveCount, open + 1, tmp + '(', res);
            dfs(s, index + 1, parenRemoveCount - 1, open, tmp, res);
        } else if (s.charAt(index) == ')') {
            if (open > 0) {
                dfs(s, index + 1, parenRemoveCount, open - 1, tmp + ')', res);
            }
            dfs(s, index + 1, parenRemoveCount - 1, open, tmp, res);
        } else {
            dfs(s, index + 1, parenRemoveCount, open, tmp + s.charAt(index), res);
        }
    }
}