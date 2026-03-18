class Solution {

    int[][] dp;
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];

        int maxPath = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }

        return maxPath;
    }

    public int dfs(int[][] matrix, int i, int j){

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int max = 1; // minimum path is 1 (itself)

        for(int[] dir : directions){

            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni >= 0 && nj >= 0 && ni < matrix.length && nj < matrix[0].length
               && matrix[ni][nj] > matrix[i][j]){

                int len = 1 + dfs(matrix, ni, nj);
                max = Math.max(max, len);
            }
        }

        return dp[i][j] = max;
    }
}