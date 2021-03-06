//Similar with 516 using dp
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        
        
        /*
        longest common sequence of s and reversed s is the longest palindrome subsequence
        
        find if the length of (len of s - lcs) <= k 
        
        how to find lcs of String s?
        1. reverse s
        2. dp[i][j]
        **/
        String s_r = new StringBuilder(s).reverse().toString();
        
        int len_lcs = lcs(s, s_r);
        
        return (s.length() - len_lcs) <= k;
    }
    
    private int lcs(String s1, String s2) {
        
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}