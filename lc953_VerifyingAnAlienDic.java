class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ======================
        HashMap<char, int> store the sort
        
        loop the array
        compare the first character
        **/
        
        if (words == null || words.length <= 1) return true;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (char c : order.toCharArray()) {
            map.put(c, i++);
        }
        
        loop:
        for (i = 1; i < words.length; i++) {
            String words1 = words[i - 1];
            String words2 = words[i];
            
            if (map.get(words1.charAt(0)) > map.get(words2.charAt(0))) {
                return false;
            } else if (map.get(words1.charAt(0)) == map.get(words2.charAt(0))) {
                
                int j = 1;
                while (j < words1.length() && j < words2.length()) {
                    if (map.get(words1.charAt(j)) > map.get(words2.charAt(j))) {
                        return false;
                    } else if (map.get(words1.charAt(j)) == map.get(words2.charAt(j))) {
                        j++;
                    } else {
                        continue loop;
                    } 
                }
                if (words2.length() < words1.length()) return false;
            } else {
                continue;
            }
        }
        return true;          
    }
}