class Solution {
    public String toGoatLatin(String S) {
        /*
        split S
        loop through each word
        have a set to hold aeiouAEIOU
        **/
        
        if (S == null || S.length() == 0) return S;
        String[] s_arr = S.split("\\s+");
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        String res = "";
        
        for (int i = 0; i < s_arr.length; i++) {
            String word = s_arr[i];
            String tmp = "";
            if (!vowel.contains(word.charAt(0)) && word.length() > 1) {
                
                tmp = word.substring(1) + word.charAt(0) + "ma";    
            } else {
                tmp = word + "ma";
            }
            
            for (int j = 0; j < i + 1; j++) {
                tmp = tmp + "a";
            }
            tmp = tmp + " ";
            res += tmp;
            
        }
        return res.trim();
    }
}