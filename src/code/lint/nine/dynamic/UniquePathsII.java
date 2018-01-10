package code.lint.nine.dynamic;


    /*
    *
    * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids.
How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Notice

m and n will be at most 100.

Have you met this question in a real interview? Yes
Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
    *
    * */


public class UniquePathsII {

    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here

       /* if(obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0){
            return 0;
        }*/

        if(obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0){
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] paths = new int[m][n];

        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] != 1){
                paths[i][0] = 1;
            }else{
                break;
            }
        }

        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] != 1){
                paths[0][i] = 1;
            }else{
                break;
            }
        }

        for(int i = 1; i < m; i++ ){
            for(int j = 1; j < n; j++){

                if(obstacleGrid[i][j] != 1){
                    paths[i][j] = paths[i-1][j] + paths[i][j - 1];
                }else{
                    paths[i][j] = 0;
                }

            }
        }

        return paths[m-1][n-1];

    }


    // JIU Zhang's Answer
    /*
    *
    *  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else {
                    paths[i][j] = 0;
                }
            }
        }

        return paths[n - 1][m - 1];
    }


    // Method 2

     public int uniquePathsWithObstacles(int[][] A) {
        int m = A.length;
        if (m == 0) {
            return 0;
        }
        int n = A[0].length;
        if (n == 0) {
            return 0;
        }

        if (A[0][0] == 1 || A[m-1][n-1] == 1) {
            return 0;
        }

        int[][] f = new int[2][n];
        int i, j, old, now;
        now = 0;

        for (i = 0; i < m; ++i) {
            old = now;
            now = 1 - now;
            for (j = 0; j < n; ++j) {
                f[now][j] = 0;
                if (A[i][j] == 1) {
                    f[now][j] = 0;
                }
                else {
                    if (i == 0 && j == 0) {
                        f[now][j] = 1;
                    }
                    if (i > 0) {
                        f[now][j] += f[old][j];
                    }
                    if (j > 0) {
                        f[now][j] += f[now][j-1];
                    }
                }
            }
        }

        return f[now][n-1];
    }

    *
    * */


    // Shuo Chang's Answer

    /*
    *
    * public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++){
            if (obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i -1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    *
    * */

}
