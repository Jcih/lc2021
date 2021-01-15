//https://www.youtube.com/watch?v=XMXIX8kNknA
//sliding window
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            while (end < s.length() && map.size() <= k) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    if (map.size() == k) {
                        break;
                    }
                    map.put(c, 1);
                }
                end++;
            }
            
            res = Math.max(res, end - i);
            
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count > 1) {
                    map.put(c, count - 1);
                } else {
                    map.remove(c);
                }
            }
        }
        return res;
    }
}