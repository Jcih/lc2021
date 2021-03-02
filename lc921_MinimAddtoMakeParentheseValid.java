class Solution {
    public int minAddToMakeValid(String S) {
        int open = 0; 
        int close = 0;
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                close++;
            } else {
                if (close > 0) {
                    close--;
                } else {
                    open++;
                }
            }
        }
        return open + close;
    }
}