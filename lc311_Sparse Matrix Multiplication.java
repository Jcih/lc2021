class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length,k = mat1[0].length, n = mat2[0].length;
        
        
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (mat1[i][j] != 0) {
                    for (int z = 0; z < n; z++) {
                        if (mat2[j][z] != 0) {
                            res[i][z] += mat1[i][j] * mat2[j][z];
                        }
                    }
                }
            }
        }
        return res;
    }
}