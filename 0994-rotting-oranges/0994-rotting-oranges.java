class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

      
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {

                    dfs(grid, i, j, 2);
                }
            }
        }

        int max = 2;

        
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

               
                if (grid[i][j] == 1) {
                    return -1;
                }

                max = Math.max(max, grid[i][j]);
            }
        }

        return max - 2;
    }

    public void dfs(int[][] grid,
                    int i,
                    int j,
                    int time) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || j < 0 ||
            i >= rows || j >= cols) {

            return;
        }

   
        if (grid[i][j] == 0) {
            return;
        }

       
       
        if (grid[i][j] != 1 &&
            grid[i][j] < time) {

            return;
        }

        
        grid[i][j] = time;

        dfs(grid, i - 1, j, time + 1);
        dfs(grid, i + 1, j, time + 1);
        dfs(grid, i, j - 1, time + 1);
        dfs(grid, i, j + 1, time + 1);
    }
}