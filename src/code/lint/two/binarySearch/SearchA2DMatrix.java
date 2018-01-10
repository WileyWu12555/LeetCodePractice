package code.lint.two.binarySearch;

/**
 * Created by 505007855 on 9/13/2017.
 */
public class SearchA2DMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.

     This matrix has the following properties:

     Integers in each row are sorted from left to right.
     The first integer of each row is greater than the last integer of the previous row.
     Have you met this question in a real interview? Yes
     Example
     Consider the following matrix:

     [
     [1, 3, 5, 7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     Given target = 3, return true.
     * */


    public static void main(String[] args){

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
                };

        int target = 3;

        boolean result = searchMatrix(matrix, target);

        System.out.println("The result is: " + result);

    }

    public static boolean searchMatrix(int[][] matrix, int target){

        if(matrix == null || matrix.length ==0 ){
            return false;
        }

        boolean result = false;

        System.out.println(matrix.length);

        int len = matrix.length;

        for(int i = 0; i < len; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(target == matrix[i][j]){
                    return true;
                }
            }
        }


        return result;
    }


    /* Jiu Zhang Answer 0 */

    // Binary Search Twice
    public boolean searchMatrix0(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        // find the row index, the last number <= target
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }

        // find the column index, the number equal to target
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }


     /* Jiu Zhang Answer 1 */
    // Binary Search Once
    public boolean searchMatrix1(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }

        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row * column - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if(number == target){
                return true;
            }else if(number > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return false;

    }


    /* Shuo Chang's Answer */

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null){
            return false;
        }
        if (matrix.length == 0){
            return false;
        }
        if (matrix[0].length == 0){
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        int mid = 0;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (matrix[mid][0] == target){
                return true;
            } else if (matrix[mid][0] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        int selectedRow;
        if (matrix[end][0] > target){
            selectedRow = start;
        } else if (matrix[end][0] == target){
            return true;
        } else {
            selectedRow = end;
        }
        start = 0;
        end = matrix[selectedRow].length - 1;
        mid = 0;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (matrix[selectedRow][mid] == target){
                return true;
            } else if (matrix[selectedRow][mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[selectedRow][end] == target){
            return true;
        }

        if (matrix[selectedRow][start] == target){
            return true;
        }
        return false;
    }
}
