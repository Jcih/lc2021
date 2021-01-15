//https://www.youtube.com/watch?v=IzynHx-O4lE
//sliding window
class Solution {
    public String minWindow(String s, String t) {
        //get t's char's freq
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        
        int start = 0;
        int count = 0;// valid chars in s for t, when count == t.length, substring valid
        
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (mapT.getOrDefault(cur, 0) > 0) {
                mapS.put(cur, mapS.getOrDefault(cur, 0) + 1);
                if (mapT.get(cur) >= mapS.get(cur)) count++;
            }
            
            //find a valid string
            if (count == t.length()) {
                
                while (mapS.getOrDefault(s.charAt(start), 0) > mapT.getOrDefault(s.charAt(start), 0) || mapT.getOrDefault(s.charAt(start), 0) == 0) {
                    //move start
                    if (mapS.getOrDefault(s.charAt(start), 0) > mapT.getOrDefault(s.charAt(start), 0))
                        mapS.put(s.charAt(start), mapS.get(s.charAt(start)) - 1);
                    start++;
                }
    
                if (result.equals("") ||i - start + 1 < result.length())
                    result = s.substring(start, i + 1);
            }
        }
        
        return result;
    }
}