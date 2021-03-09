class Solution {
    public int minDeletions(String s) {
        
        /*
        count the frequency of each char
        Set to store frequencies
        if frequency in set, -1 and check if still in set

        **/
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for (int i : arr) {
            if (i == 0) continue;
            while (i != 0 && set.contains(i)) {
                i--;
                res++;
            }
            set.add(i);
            
        }
        return res;
    }
}