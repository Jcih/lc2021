class Solution {
    public String reverseWords(String s) {
        /*
        1. trim and split the string
        2. append from the last word
        
        **/
        
        String[] words = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        
        return sb.toString().trim();
    }
}