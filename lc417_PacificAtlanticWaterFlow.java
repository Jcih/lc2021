//DFS
class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //M[i][j] should make sure (left || top) && (right || bot)
        //                         boolean pacifit    boolean atlantic


        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacf = new boolean[m][n];
        boolean[][] atla = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacf, i, 0);
            dfs(matrix, atla, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, pacf, 0, j);
            dfs(matrix, atla, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacf[i][j] && atla[i][j]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }
    
    
    public void dfs(int[][] matrix, boolean[][] reach, int x, int y) {
        if (reach[x][y]) return;
        
        reach[x][y] = true;
        
        int r, c;
        for (int i = 0; i < 4; i++) {
            r = x + dir[i];
            c = y + dir[i + 1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length &&
                matrix[x][y] <= matrix[r][c]) {
                //means can flow
                dfs(matrix, reach, r, c);
            }
            
        }
        
    }
}