class Solution {
    public String intToRoman(int num) {
        /*
        1. example
        2. data structure / algo
            Map each digit to Roman, use array 
        3. logic
            thousand: num / 1000
            hundresds: 4800 - >  num % 1000 = 800, 800 / 100 = 8
            tens: 4810 -> num % 100 = 10, 10 / 10 = 1
            ones: 4871 -> num % 10 = 1
        
        
        4. reuslt
        5. analysis : TimeO(1), num operation is same, Space: O(1), fixed array size
        ============================
        3 III
        12: 12 % 10 = 1, 2 % 1 = 2 , XII
        9: IX
        58: LVIII
        ============================

        */
        
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
        
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
}