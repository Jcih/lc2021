class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        int r = 0, c = 0;
        
        for (int i = 0; i < row * col; i++) {
            res[i] = matrix[r][c];
            
            if ( (r + c) % 2 == 0) {
                //go up
                if (r - 1 >= 0 && c + 1 < col) {
                    r = r - 1;
                    c = c + 1;
                } else if (c + 1 < col) {
                    c = c + 1;
                } else {
                    r = r + 1;
                }
                
            } else {
                //go down
                if (r + 1 < row && c - 1 >= 0) {
                    r = r + 1;
                    c = c - 1;
                } else if (r + 1 < row) {
                    r = r + 1;
                } else {
                    c = c + 1;
                }                
            }
        }
        return res;
    }
}