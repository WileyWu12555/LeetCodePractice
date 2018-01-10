package code.lint.two.binarySearch;


/*
*
* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Have you met this question in a real interview? Yes
Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

Challenge
O(logN) time

假设有一个排序的按未知的旋转轴旋转的数组
(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。

你可以假设数组中不存在重复的元素。

*
* */
public class SearchInRotatedSortedArray {

    /*
         * @param A: an integer rotated sorted array
         * @param target: an integer to be searched
         * @return: an integer
         */
    public int search(int[] A, int target) {
        // write your code here

        if(A == null || A.length == 0){
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid = 0;

        while(start + 1 < end){
            mid = start + (end - start) / 2;

            if(target == A[mid]){
                return mid;
            }

           /*
           // Doesn't work
           if((A[start] < A[mid]) && (target >= A[start] && target < A[mid])){
                end = mid;
            }else if((A[start] < A[mid]) && (target >= A[start] && target > A[mid])){
                start = mid;
            } else if ((A[start] > A[mid]) && (target >= A[start])) {
                end = mid;
            } else if ((A[start] > A[mid]) && (target <= A[start] && target < A[mid])) {
                end = mid;
            } else if ((A[start] > A[mid]) && (target <= A[start] && target > A[mid])) {
                start = mid;
            }*/

           if(A[start] < A[mid]){
               if(A[start] <= target && target <= A[mid]){
                   end = mid;
               }else{
                   start = mid;
               }
           }else{
               if(A[mid] <= target && target <= A[end]){
                   start = mid;
               }else{
                   end = mid;
               }
           }

        }

        if (A[start] == target){
            return start;
        }

        if(A[end] == target){
            return end;
        }

        return -1;

    }

    // Jiu Zhang's Answer

    /*
    *
    * public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, red line
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, green line
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
    *
    * */


    // Shuo Chang's Answer
    /*
    *
    * public int search(int[] A, int target) {
        if (A == null || A.length == 0){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (target > A[end]){
                if (A[mid] < target && A[mid] > A[end] ){
                    start = mid;
                } else if (A[mid] == target){
                    return mid;
                } else {
                    end = mid;
                }
            } else {
                if (A[mid] > target && A[mid] < A[end]){
                    end = mid;
                } else if (A[mid] == target){
                    return mid;
                } else {
                start = mid;
                }
            }
        }
        if (A[start] == target){
            return start;
        }

        if (A[end] == target){
            return end;
        }
        return -1;
    }
    *
    * */
}
