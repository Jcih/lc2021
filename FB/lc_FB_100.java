//1498. Number of Subsequences That Satisfy the Given Sum Condition
class Solution {
    public int numSubseq(int[] nums, int target) {
        /*
        sort the araay to easilt find the max and min by left, and right

        **/

        Arrays.sort(nums);
        int res = 0;
        
        int left = 0, right = nums.length - 1;
        int mod = (int)1e9 + 7;
        int[] pow = new int[right + 1];
        pow[0] = 1;
        
        //from 0 to i, the number of permutaions
        for (int i = 1; i <= right; i++) {
            pow[i] = 2 * pow[i - 1] % mod;
        }
        
        
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + pow[right - left]) % mod;// from left to right, number of permutations
                left++;
            }
        }
        return res;
    }
}



// 616  Add Bold Tag in String
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