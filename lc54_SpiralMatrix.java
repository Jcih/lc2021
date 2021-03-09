class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
        defien four boundaries to loop
        left, right, top, bottom
        
        **/
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = col - 1, top = 0, bot = row - 1;
        int n = row * col;
        
        int i = 0;
        while (i < n) {
            
            //left to right
            for (int j = left; j <= right && i < n; j++) {
                res.add(matrix[top][j]);
                i++;
            }
            top++;
            
            //top to bot
            for (int j = top; j <= bot && i < n; j++) {
                res.add(matrix[j][right]);
                i++;
            }
            right--;
            
            //from right to left
            for (int j = right; j >= left && i < n; j--) {
                res.add(matrix[bot][j]);
                i++;
            }
            bot--;
            
            //from bot to top
            for (int j = bot; j>= top && i < n; j--) {
                res.add(matrix[j][left]);
                i++;
            }
            left++;
        }
        return res;
    }
}