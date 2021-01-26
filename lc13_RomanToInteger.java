class Solution {
    public int romanToInt(String s) {
        /*
        1. test
        2. data structure: HashMop store pairs, while loop on pass.
        3. logic
        4. result
        5. analysis
        
        ===============
        III 3
        IV 4
        IX 9
        ===============
        find two combinations first,if not , find one
        
        */
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        
        int n = s.length();
        int sum = 0;
        int i = 0;
        while (i < n) {
            if (i + 2 <= n) {
                String combo = s.substring(i, i + 2);
                if (map.containsKey(combo)) {
                    sum += map.get(combo);
                    i += 2;
                    continue;
                } 
            } 
            String roman = s.substring(i, i + 1);
            sum += map.get(roman);
            i += 1;   
        }
        return sum;
    }
}