class Solution {
    public int myAtoi(String s) {
        
        /*
        1. trim the string
        2. get the sign
        3. if char not number, break
        4. if char is number, convert to int
        5. edge cases
        **/
        
        s = s.trim();
        if (s == null || s.length() == 0) return 0;
        
        boolean isNegtive = false;
        double res = 0;
        
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') start++;
        if (s.charAt(0) == '-') isNegtive = true;
        
        for (int i = start; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur > '9' || cur < '0') break;
            
            int num = cur - '0';
            res = res * 10 + num;
        }
        
        if (isNegtive) {
            res = -res;
        }
        
        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        return (int)res;
        
        
    }
}