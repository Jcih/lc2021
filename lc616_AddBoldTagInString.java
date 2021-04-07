class Solution {
    public String addBoldTag(String s, String[] dict) {
        /*
        loop string: 1. build an array to represent each char bold or not
        
            loop dict for each char, if s.startwith(word, i) then from i to i + word.length, mark bold
            i = i + word.length - 1;
        
        build res: loop s: if bold[i] is false, append char; else : append <b>, and append until bold[i] is false; and append </b>
        */
        boolean[] bold = new boolean[s.length()];
        
        for (int start = 0; start < s.length(); start++) {
            int maxEnd = start - 1;
            for (String word : dict) {
                if (word.isEmpty()) continue;
                if (s.startsWith(word, start)) {
                    maxEnd = start + word.length() - 1;
                }
            }
            
            if (maxEnd < start) continue;
            for (int i = start; i <= maxEnd; i++) {
                bold[i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int start = 0; start < s.length(); start++) {
            if (!bold[start]) {
                sb.append(s.charAt(start));
                continue;
            }
            
            sb.append("<b>");
            int end = start;
            while (end < s.length() && bold[end]) {
                end++;
            }
            sb.append(s.substring(start, end));
            sb.append("</b>");
            start = end - 1;
        }
        return sb.toString();
    }
}




//

class Solution {
    public String addBoldTag(String s, String[] dict) {
        /*
        
        loop string s,
        
        for each char, loop dict, anc check if the word in dict is the start in s
              s.startWith(word, index), if yes, update bold array to true, from i, to i + word.length
        
        loop s: if bold[i] is  true, append <b> + char until bold[i] is false, append </b>
                else append char
        
        **/
        
        int n = s.length();
        boolean[] bold = new boolean[n];
        
        
        for (int i = 0; i < s.length(); i++) {
            int boldIndex = -1;
            
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    //update bold array
                    boldIndex = Math.max(boldIndex, i + word.length() - 1);
                }
            }
            
            if (boldIndex != -1) {
                for (int k = i; k <= boldIndex;k++) {
                    bold[k] = true;
                   
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        
        while (start < n) {
            if (!bold[start]) sb.append(s.charAt(start++));
            
            else {
                sb.append("<b>");
                
                while (start < n && bold[start]) {
                    sb.append(s.charAt(start++));
                }
                
                sb.append("</b>");
            }
            
            
        }
        
        return sb.toString();
        
    }
}