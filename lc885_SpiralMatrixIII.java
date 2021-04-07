class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        
        int total = R * C;
        int i = r0, j = c0;
        int count = 0;
        int[][] res = new int[total][2];
        int step = 0;
        
        while (count < total) {
            
            step++;
            //move right
            for (int a = 0; a < step; a++) {
                if (i >= 0 && i < R && j >= 0 && j < C) res[count++] = new int[] {i, j};
                j++;
            }
            
            //move down
            for (int a = 0; a < step; a++) {
                if (i >= 0 && i < R && j >= 0 && j < C) res[count++] = new int[] {i, j};
                i++;
            }
            
            step++;
            
            //move left
            for (int a = 0; a < step; a++) {
                if (i >= 0 && i < R && j >= 0 && j < C) res[count++] = new int[] {i, j};
                j--;
            }
            
            //move up
            for (int a = 0; a < step; a++) {
                if (i >= 0 && i < R && j >= 0 && j < C) res[count++] = new int[] {i, j};
                i--;
            }
        }
        return res;
    }
}