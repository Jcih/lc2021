//https://www.youtube.com/watch?v=97oTiOCuxho
//easy understand
class Solution {
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j = 0;
        while (i < A.length) {
            if (A[i] == 0)
                K--;
            if (K < 0) {
                if (A[j] == 0) {
                    K++;
                }
                j++;
            }
            i++;
        }
        return i - j;
    }
}