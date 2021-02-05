class Solution {
    public boolean isPalindrome(String s) {
        /*
        Alphanumeric
        **/



        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        
        s = sb.toString().toUpperCase();
        
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}