class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // build two hashmap to store the char pairs
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        if (s.length() != t.length()) return false;
        
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if (map1.containsKey(a)) {
                if (b != map1.get(a)) return false;
            } else {
                if (map2.containsKey(b)) return false;
                map1.put(a, b);
                map2.put(b, a);
            }
        }
        return true;
        
    }
}