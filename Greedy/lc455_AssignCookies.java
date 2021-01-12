//greedy
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        int res = 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int k = 0;
        for (int i = 0; i < s.length; i++) {
            if (k < g.length && s[i] >= g[k]) {
                res++;
                k++;
            }
        }
        
        return res;
    }
}