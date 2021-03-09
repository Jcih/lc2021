//https://www.youtube.com/watch?v=pD3cHFNyW2I

class Solution {
    
    int res = 0;
    public int maxLength(List<String> arr) {
        /*
        1. backtracking generates all combinations
        2. check if the generated string has duplicate chars
        
        **/
        
        helper(arr, 0, "");
        return res;
    }
    
    public void helper(List<String> arr, int index, String cur) {
        //base case
        if (index == arr.size() && checkUniqueChar(cur) > res) {
            res = cur.length();
            return;
        }
        
        if (index == arr.size()) return;
        
        //recursive case
        helper(arr, index + 1, cur + arr.get(index));// taking the current word
        helper(arr, index + 1, cur); // not taking the current word
        
    }
    
    public int checkUniqueChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (count[c - 'a']++ > 0) {
                return -1;
            }
        }
        return s.length();
    }
    
    
    
}