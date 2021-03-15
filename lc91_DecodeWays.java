//DP
class Solution {
    public int numDecodings(String s) {
        
        /*
        DP:
        
        0 1 2 3 4
        1 1 1 0 6
      0 1 2 3 4 5
      0 1         
        **/
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0: 1;
        
        for (int i = 2; i <= s.length(); i++) {
            int one = s.charAt(i - 1) - '0';
            int two = Integer.valueOf(s.substring(i - 2, i));
            
            int num1 = one == 0 ? 0 : dp[i - 1];
            int num2 = 10 <= two && two <= 26 ? dp[i - 2] : 0;
            
            dp[i] = num1 + num2;
            
        }
        return dp[s.length()];
    }
    
    
  
}