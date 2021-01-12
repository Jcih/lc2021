//https://www.youtube.com/watch?v=5NCjHqx2v-k
// greedy
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        
        int[] last_indices = new int[26];
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            last_indices[c - 'a'] = i;
        }
        
        int start = 0, end = 0;
        
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last_indices[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}