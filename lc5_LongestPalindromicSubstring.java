
//DP https://www.youtube.com/watch?v=ZnzvU03HtYk
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dp[i][j] = true;
            }
        }
        
        int l = 0, r = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) { 
                dp[i][j] = (dp[i + 1][j - 1] || j - i <= 2) && s.charAt(i) == s.charAt(j) ;
                if (dp[i][j]) {
                    if (j - i > r - l) {
                        r = j;
                        l = i;
                    }
                    
                }
            }
        }
        return s.substring(l, r + 1);
    }
}

//expand https://www.youtube.com/watch?v=y2BD4MJqV20
class Solution {
    public String longestPalindrome(String s) {
        /*
        abba  expand start from bb
        aba   expand start from b
        **/
            
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            
            int l1 = expand(s, i, i + 1);
            int l2 = expand(s, i, i);
            
            int len = Math.max(l1, l2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            
        }    
        return s.substring(start, end + 1);
            
            
    }
    
    private int expand(String s, int i, int j) {
        if (s == null || i > j) return 0;
        
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        
        return j - i - 1;
        
        
    }
}