//https://www.youtube.com/watch?v=21OuwqIC56E
class Solution {
    public List<String> letterCombinations(String digits) {
        
        /*
        build a map or arr to mapping digits and letter
        
        backtrack 
        loop the letter list of the digit
        
        when the generated string length == digits.length; add to res;
        
        **/
        
        String[] mapping = {"0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        
        helper(res, 0, digits, "", mapping);
        return res;
    }
    
    private void helper(List<String> res, int index, String digits, String cur, String[] mapping) {
        if (cur.length() == digits.length()) {
            res.add(new String(cur));
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, index + 1, digits, cur + letters.charAt(i), mapping);
        }
        
    }
}