//similar to 1216
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        
        String s2 = new StringBuilder(s).reverse().toString();
        return helper(s, s2);
    }
    
    private int helper(String a, String b) {
        
        int n = a.length();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
        
    }
}