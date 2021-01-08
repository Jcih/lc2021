class Solution {
    public boolean canConstruct(String s, int k) {
        int odd = 0;
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (int i : freq) {
            if (i % 2 == 1) odd++;
        }
        return odd <= k && k <= s.length();
    }
}