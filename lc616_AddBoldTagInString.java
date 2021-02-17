class Solution {
    public String addBoldTag(String s, String[] dict) {
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