class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // build two hashmap to store the char pairs

        /*
        1. test 
        2. data structure, algo: HashMap
        3. logic
        4. reuslt
        5. analysis
        ===============
        e -> a
        g -> d
        egg -> edd
        
        foo
        bar
        f -> b
        o -> a
        o != r
        ========================
        s_map
        t_map
        if (char in s) {
           s_map.get() == char in t
        } else {
           if (char t in t map) return false
           maps.put()
           mapt.put()
        }
        
        return true;
        */
        
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