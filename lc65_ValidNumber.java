//https://www.youtube.com/watch?v=5gmtCtAooZE
class Solution {
    public boolean isNumber(String s) {
        /*
        there are cases: +/-, . , e/E, digits, others
        for +/-: have to be first or first after e
        . : have to be before e, and only one .
        e/E: only one e/E
        digits: mark seen digits, so which will impact e/E and .
        others: not allowed

        **/
        s = s.trim();
        boolean eSeen = false;
        boolean numSeen = false;
        boolean dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numSeen = true;
                
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numSeen = false;
            } else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        return numSeen;
    }
}