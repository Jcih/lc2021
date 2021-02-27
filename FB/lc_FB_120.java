//266. Palindrome Permutation
class Solution {
    public boolean canPermutePalindrome(String s) {
        /*
        map to store the frequency
        if there are greater than 1 odd frequency characters, return false;
        else return true;
        
        
        **/
        
        if (s == null || s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count_odd = 0;
        
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) count_odd++;
            if (count_odd > 1) return false;
        }
        return true;
    }
}



//39
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        /*
        
        sort candidates
        backtrack
        res, 0, cur, target
        
        **/
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, new ArrayList<>(), target, candidates);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int index, List<Integer> cur, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(res, i, cur, target - candidates[i], candidates);
            cur.remove(cur.size() - 1);
        }
        
    }
}



//1216. Valid Palindrome III
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