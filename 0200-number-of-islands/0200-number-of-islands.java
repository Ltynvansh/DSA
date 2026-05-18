class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean [][] visited = new boolean[rows][cols];
        int count =0;
        for(int i =0; i<rows; i++){
            for(int j =0 ; j<cols ; j++){
                
                if(grid[i][j] == '1' && !visited[i][j] ){
                    count ++;
                    dfs(grid, visited,i ,j );
                    

                }
            }
        }
        return count ;


        
    }
    public void dfs(char[][] grid , boolean [][] visited , int i,int j ){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0 || j<0 || i>= rows || j>= cols || visited[i][j]|| grid[i][j] == '0'){
            return ;
        }
        visited [i][j] = true ;
        dfs(grid, visited , i+1,j);
        dfs(grid , visited, i-1 , j);
        dfs(grid, visited, i,j+1);
        dfs(grid, visited , i,j-1);
    }
}