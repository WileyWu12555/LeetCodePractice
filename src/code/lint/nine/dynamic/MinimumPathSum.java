package code.lint.nine.dynamic;

/*
*
* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Notice

You can only move either down or right at any point in time.
*
* */

public class MinimumPathSum {

    /*
    * @param grid: a list of lists of integers
    * @return: An integer, minimizes the sum of all numbers along its path
    */
    public int minPathSum(int[][] grid) {
        // write your code here

        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m][n];

        sum[0][0] = grid[0][0];

        for(int i = 1; i < m; i++){
            sum[i][0] = sum[i -1][0] + grid[i][0];
        }

        for(int j = 1; j < n; j++){
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = Math.min(sum[i -1][j] , sum[i][j-1]) + grid[i][j];
            }
        }
        return sum[m-1][n-1];
    }


    // JIU zhang's Answer

    /*
    *
    * public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];
    }


    // Method 2

     public int minPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int m = A.length, n = A[0].length;
        int[][] f = new int[2][n];
        int old, now = 0;

        for (int i = 0; i < m; ++i) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < n; ++j) {
                int min = -1;
                if (i > 0 && (min == -1 || f[old][j] < min)) {
                    min = f[old][j];
                }
                if (j > 0 && (min == -1 || f[now][j-1] < min)) {
                    min = f[now][j-1];
                }

                if (min == -1) {
                    min = 0;
                }

                f[now][j] = min + A[i][j];
            }
        }

        return f[now][n-1];
    }
    *
    * */


    // Shuo Chang's Answer

    /*
    *
    * public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2 ; i >= 0; i--){
            dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];
        }

        for (int i = m - 2; i >= 0; i--){
            dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n -1];
        }

        for (int i = m - 2; i >= 0; i--){
            for (int j = n - 2; j >= 0; j--){
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }

        return dp[0][0];
    }
    *
    * */

    //top to bottom
/*public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++){
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < m; i++ ){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j] , dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];

    }
}*/

}
