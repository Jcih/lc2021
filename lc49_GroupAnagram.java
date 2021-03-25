class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /* sort each word, and add to HashMap
         if the new word is sorted and in map, add to the value
        return value of map
        */
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            
            String cur = strs[i];
            char[] cur_array = cur.toCharArray();
            Arrays.sort(cur_array);
            String sorted = new String(cur_array);
            
            if (map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(strs[i]);
            }
            
        }
        res.addAll(map.values());
        return res;
        
        
        
    }
}