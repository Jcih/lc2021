class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //https://www.youtube.com/watch?v=vUd-7qS6BPQ
        
        /*
        acef  bdfg 
        0245  1356
              -1
              0245   same pattern
              
              25 1 3 4
              -25
              0 -24 -22 -21  mod 26
              0 2 4 5
              
        store the key in the hash map, for each word in a string, generate a key,
        if add the word to the list of same key
        **/
        
        
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strings) {
            String key = getPattern(word);
            
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(word);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        
        return res;
    }
    
    private String getPattern(String word) {
        
        int first = word.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        
        for (char c : word.toCharArray()) {
            int num = c - 'a';
            
            num = num - first;
            if (num < 0) num = num + 26;
            sb.append(num + ","); // to distinguish 1 2 and 12
        }
        return sb.toString();
    }
    
    
}