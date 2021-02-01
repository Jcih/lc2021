class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        
        =================
        track the maximum of time diff, add char to result
        sort res, get the last char.
        */
        
        
        List<Character> list = new ArrayList<>();
        int n = keysPressed.length();
        
        int time = releaseTimes[0];
        char[] keyArr = keysPressed.toCharArray();
        
        char c = keyArr[0];
        list.add(c);
        
        for (int i = 1; i < n; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            char a = keyArr[i];
            
            if (diff > time) {
                list.clear();
                list.add(a);
                time = diff;
            } else if (diff == time) {
                list.add(a);
            } else {
                continue;
            }
        }
        
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}