import java.util.*;

class Solution {

    int helper(int row, int col, int m, int n, ArrayList<ArrayList<Integer>> dp){

        if(row == m-1 && col == n-1){
            return 1;
        }

        if(dp.get(row).get(col) != -1){
            return dp.get(row).get(col);
        }

        int r = 0;
        if(col + 1 < n){
            r = helper(row, col + 1, m, n, dp);
        }

        int b = 0;
        if(row + 1 < m){
            b = helper(row + 1, col, m, n, dp);
        }

        dp.get(row).set(col, r + b);
        return dp.get(row).get(col);
    }

    public int uniquePaths(int m, int n) {

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for(int i = 0; i < m; i++){
            dp.add(new ArrayList<>(Collections.nCopies(n, -1)));
        }

        return helper(0, 0, m, n, dp);
    }
}