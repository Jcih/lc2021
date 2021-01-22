class Solution {
    public boolean validPalindrome(String s) {
        //use two pointer to check if palindrome
        // else remove one, (left + 1, r) || (left, right - 1) isPalindrome
        
        int left = 0, right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalind(s, left + 1, right) || isPalind(s, left, right - 1);
            }
        }
        
        return true;
    }
    
    public boolean isPalind(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}