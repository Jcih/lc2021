class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int r = matrix.length, c = matrix[0].length;
        sum = new int[r + 1][c + 1]; // add one layer to take care the edge case when the 1st row and col need to be calculated
    
        //i <= r, j <= c, be cautious
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1]; // matrix[i - 1][j - 1] be cautious
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        res = sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1]; // add one in the original index
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */