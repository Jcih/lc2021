//Time Complexity: O(M * N) where M is the row of grid, N is the col of grid
class Solution {
	public int numDistinctIslands(int[][] grid) {

		Set<String> paths = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					//encounter the island, build a distinct string
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, sb, "o");//original
					paths.add(sb.toString());
				}
			}
		}
		return paths.size();
	}

	private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {

        //edge cases
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;

        grid[i][j] = 0;//mark as visited
        sb.append(dir);

        dfs(grid, i - 1, j, sb, "u");//up
        dfs(grid, i + 1, j, sb, "d");//down
        dfs(grid, i, j - 1, sb, "l");//left
        dfs(grid, i, j + 1, sb, "r");//right
        sb.append("e");// end, records the case that "'hit a wall"

	}
}