class Solution {
    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
       
        while (i <= j) {
            if (!map.containsKey(num.charAt(i))) return false;
            if (num.charAt(j) != map.get(num.charAt(i))) return false;
            
            i++;
            j--;
        }
        
        
        return true;
    }
}