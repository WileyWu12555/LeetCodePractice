package code.lint.nine.dynamic;

/*
*
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 Notice

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Have you met this question in a real interview? Yes
Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*
* */

public class Triangle {

    public int minimumTotal(int[][] triangle) {
        // write your code here

        if(triangle == null || triangle.length == 0) {

            return -1;
        }

        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }

        int n = triangle.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++){
            result[n-1][i] = triangle[n-1][i];
        }

        for(int i = n-2; i >= 0; i-- ){
            for(int j = 0; j <= i; j++){
                result[i][j] = Math.min(result[i + 1][j], result[i+1][j+1]) + triangle[i][j];
            }
        }
        return result[0][0];
    }

    // Jiu Zhang's Answer
    /*
    *

    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }

        // top down
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }

        // answer
        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }
    *
    * */

    //Version 1: Bottom-Up
    /*
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }

        // bottom up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }

        // answer
        return f[0][0];
    }
    */

    //Version 2 : Memorize Search
  /*  public class Solution {
        private int n;
        private int[][] minSum;
        private int[][] triangle;

        private int search(int x, int y) {
            if (x >= n) {
                return 0;
            }

            if (minSum[x][y] != Integer.MAX_VALUE) {
                return minSum[x][y];
            }

            minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1))
                    + triangle[x][y];
            return minSum[x][y];
        }

        public int minimumTotal(int[][] triangle) {
            if (triangle == null || triangle.length == 0) {
                return -1;
            }
            if (triangle[0] == null || triangle[0].length == 0) {
                return -1;
            }

            this.n = triangle.length;
            this.triangle = triangle;
            this.minSum = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    minSum[i][j] = Integer.MAX_VALUE;
                }
            }

            return search(0, 0);
        }
    } */


    // Shuo Zhang's Answer
    /*
    *
    *  public int minimumTotal(int[][] triangle){
        if (triangle == null || triangle.length == 0){
            return -1;
        }
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++){
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            dp[i][n - 1] = triangle[i][n - 1] + dp[i-1][n - 1];
        }

        for (int i = 1 ; i < n; i++){
            for (int j = 1; j < i ; j++){
               dp[i][j] = triangle[i][j] + Math.min(dp[i - 1][j],  dp[i -1][j - 1]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            result = Math.min(result,dp[n-1][i]);
        }
        return result;

    }
    *
    * */

    /*public class Solution {

    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0){
            return 0;
        }
        int[][] hash = new int[triangle.length][triangle.length];
        for (int i = 0; i < triangle.length; i++){
            for (int j = 0; j < triangle.length; j++){
                hash[i][j] = Integer.MAX_VALUE;
            }
        }
        int result = helper(triangle, 0, 0, hash);
        return result;
    }
    public int helper(int[][] triangle, int x, int y, int[][] hash ){
        if (x == triangle.length){
            return 0;
        }
        if (hash[x][y] != Integer.MAX_VALUE){
            return hash[x][y];
        }
        int leftAns = helper( triangle, x + 1, y, hash);
        int rightAns = helper( triangle, x + 1, y + 1, hash);
        hash[x][y] = triangle[x][y] + Math.min(leftAns, rightAns);
        return hash[x][y];
    }
}*/

/*public class Solution {
    public int minimumTotal(int[][] triangle){
        if (triangle == null || triangle.length == 0){
            return -1;
        }
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < triangle.length; i++){
            dp[n - 1][i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}*/

}
