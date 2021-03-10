class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /*
        Use two pointer i, j
        maintain a set to keep unique substring chars
        each time j move forward, update max length

        **/
        
        int i = 0, j = 0, res = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                res = Math.max(res, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}