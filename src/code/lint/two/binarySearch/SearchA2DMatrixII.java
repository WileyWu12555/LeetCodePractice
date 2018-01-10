package code.lint.two.binarySearch;


    /*
    *
    *
 Write an efficient algorithm that searches for a value in an m x n matrix,
 return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Have you met this question in a real interview? Yes
Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space

写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。

这个矩阵具有以下特性：

每行中的整数从左到右是排序的。
每一列的整数从上到下是排序的。
在每一行或每一列中没有重复的整数。

    *
    * */

public class SearchA2DMatrixII {

    /*
         * @param matrix: A list of lists of integers
         * @param target: An integer you want to search in matrix
         * @return: An integer indicate the total occurrence of target in the given matrix
         */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here

        if(matrix == null || matrix.length == 0){
            return 0;
        }

        if(matrix[0] == null || matrix[0].length == 0){
            return 0;
        }

        int row_length = matrix.length;
        int column_length = matrix[0].length;

        int y = 0;
        int x = row_length - 1;
        int count = 0;


        while(y < column_length && x >= 0){

            if(matrix[x][y] < target){
                y++;
            }else if(matrix[x][y] > target){
                x--;
            }else {
                count++;
                x--;
                y++;
            }

        }

        return count;
    }


    // Jiu Zhang's Answer

    /*
    *
    * // Method 1
    *
    * public int searchMatrix(int[][] matrix, int target) {
        // check corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // from bottom left to top right
        int n = matrix.length;
        int m = matrix[0].length;
        int x = n - 1;
        int y = 0;
        int count = 0;

        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }

    // Method 2

     public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int r = matrix.length - 1;
        int c = 0;
        int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                ans++;
                r--;
                c++;
                continue;
            }
            if (target < matrix[r][c]) {
                r--;
            } else {
                c++;
            }
        }
        return ans;
    }


    *
    * */



    // Shuo Chang's Answer

    /*
    *
    * public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null){
            return 0;
        }
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int column = matrix[0].length - 1;
        int row = 0;
        int count = 0;
        while(row < matrix.length && column >= 0){
            if (row < matrix.length && column >= 0  && matrix[row][column] > target){
                column--;
            } else if (row < matrix.length && column >= 0 &&  matrix[row][column] < target){
                row++;
            } else {
                count++;
                column--;
                row++;
            }
        }
        return count;
    }
    *
    * */

}
