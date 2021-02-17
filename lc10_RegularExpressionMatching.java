class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        
        boolean firstMatch = s.length() > 0 &&
                             (s.charAt(0) == p.charAt(0) ||
                             p.charAt(0) == '.'); // first character match condition
        
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || // a* 0 times
                   (firstMatch && isMatch(s.substring(1), p)); // a* multiple times, then compare the rest of s with full p
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));// first match and compare the rest
        }
    }
}