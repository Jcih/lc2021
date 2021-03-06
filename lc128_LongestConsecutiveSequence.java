class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        1. Store all nums in a set for search
        2. for each i: search if i + 1 in the set, if yes, count + 1
                              else : update result by max(res, count)
        3. if set.contains(i - 1) continue, means this have been counted    
        */
        if (nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        int res = 1;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int count = 1;
                
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                
                res = Math.max(res, count);
            }
        }
        return res;
    }
}