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