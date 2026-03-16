import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                set.add(grid[i][j]); // size 0 rhombus

                for(int size = 1; size < 50; size++){

                    if(i - size < 0 || i + size >= m || j - size < 0 || j + size >= n)
                        break;

                    int sum = 0;

                    int r = i - size;
                    int c = j;

                    // top → right
                    for(int k = 0; k < size; k++){
                        sum += grid[r + k][c + k];
                    }

                    // right → bottom
                    for(int k = 0; k < size; k++){
                        sum += grid[i + k][j + size - k];
                    }

                    // bottom → left
                    for(int k = 0; k < size; k++){
                        sum += grid[i + size - k][j - k];
                    }

                    // left → top
                    for(int k = 0; k < size; k++){
                        sum += grid[i - k][j - size + k];
                    }

                    set.add(sum);
                }
            }
        }

        int k = Math.min(3, set.size());
        int[] ans = new int[k];

        int idx = 0;
        for(int val : set){
            if(idx == k) break;
            ans[idx++] = val;
        }

        return ans;
    }
}