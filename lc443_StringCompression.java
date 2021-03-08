class Solution {
    public int compress(char[] chars) {
        /**
        
        loop through the chars array
        pointer i will locate the first new char
        pointer j start from i, and count the number of same char[i]
        while char[j] is different.
        
        append char[i] with number j - i
        if (j - i > 1) append number
        
        update i to j
        
        */
        
        int i = 0;
        int index = 0;// used for update chars[]
        while (i < chars.length) {
            int j = i;
            
            //count same chars with chars[i]
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            
            chars[index] = chars[i];
            index++;
            
            if (j - i > 1) {
                char[] num = (j - i + "").toCharArray();
                for (char c : num) {
                    chars[index] = c;
                    index++;
                }
            }
            
            i = j;
            
        }
        return index;
    }
}