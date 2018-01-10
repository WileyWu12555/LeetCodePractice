package code.lint.two.binarySearch;

/*
*
* Given a sorted array of integers, find the left_starting and left_ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。

如果目标值不在数组中，则返回[-1, -1]
*
* */
public class SearchForARange {

    /*
    * @param A: an integer sorted array
    * @param target: an integer to be inserted
    * @return: a list of length 2, [index1, index2]
    */
    public int[] searchRange(int[] A, int target) {
        // write your code here

        int[] result = new int[2];

        if(A == null || A.length == 0){
            return new int[]{-1, -1};
        }


        int left_start = 0;
        int left_end = A.length - 1;

        if(A[0] == target && A[left_end] == target){
            return new int[]{0, left_end};
        }

        while(left_start + 1 < left_end){
            int mid = left_start + (left_end - left_start) / 2;

            if(A[mid] < target){
                left_start = mid;
            }else {
                left_end = mid;
            }
        }

        if(A[left_start] == target){
            result[0] = left_start;
        }else if(A[left_end] == target){
            result[0] = left_end;
        }else {
            return new int[]{-1, -1};
        }
        
        int right_start = 0;
        int right_end = A.length - 1;

        while(right_end - 1 > right_start){
            int mid = right_start + (right_end - right_start) / 2;

            if(A[mid] > target){
                right_end = mid;
            }else {
                right_start = mid;
            }

        }

        if(A[right_end] == target){
            result[1] = right_end;
        }else if(A[right_start] == target){
            result[1] = right_start;
        }else{
            return new int[]{-1, -1};
        }
        
        return result;

    }

    // Jiu Zhang's Answer

    /*
    *
    * public int[] searchRange(int[] A, int target) {
        if (A.length == 0) {
            return new int[]{-1, -1};
        }

        int left_start, left_end, mid;
        int[] bound = new int[2];

        // search for left bound
        left_start = 0;
        left_end = A.length - 1;
        while (left_start + 1 < left_end) {
            mid = left_start + (left_end - left_start) / 2;
            if (A[mid] == target) {
                left_end = mid;
            } else if (A[mid] < target) {
                left_start = mid;
            } else {
                left_end = mid;
            }
        }
        if (A[left_start] == target) {
            bound[0] = left_start;
        } else if (A[left_end] == target) {
            bound[0] = left_end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        // search for right bound
        left_start = 0;
        left_end = A.length - 1;
        while (left_start + 1 < left_end) {
            mid = left_start + (left_end - left_start) / 2;
            if (A[mid] == target) {
                left_start = mid;
            } else if (A[mid] < target) {
                left_start = mid;
            } else {
                left_end = mid;
            }
        }
        if (A[left_end] == target) {
            bound[1] = left_end;
        } else if (A[left_start] == target) {
            bound[1] = left_start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        return bound;
    }
    *
    * */

    // Shuo Chang's Answer

    /*
    *
    * public int[] searchRange(int[] A, int target) {

        int[] result = new int[2];
        int left_start = 0;
        int left_end = A.length - 1;
        if (A == null || A.length == 0){
            return new int[]{-1,-1};
        }
        while (left_start + 1 < left_end){
            int mid = left_start + (left_end - left_start) / 2;
            if (A[mid] == target){
                left_end = mid;
            } else if (A[mid] < target){
                left_start = mid ;
            } else {
                left_end = mid;
            }
        }
        if (A[left_start] == target){
            result[0] = left_start;
        }else if (A[left_end] == target){
            result[0] = left_end;
        }else {
            result[0] = result[1] = -1;
            return result;
        }
        left_start = 0;
        left_end = A.length - 1;
         while (left_start + 1 < left_end){
            int mid = left_start + (left_end - left_start) / 2;
            if (A[mid] == target){
                left_start = mid;
            } else if (A[mid] < target){
                left_start = mid ;
            } else {
                left_end = mid;
            }
        }
        if (A[left_end] == target){
            result[1] = left_end;
        }else if(A[left_start] == target){
            result[1] = left_start;
        }else {
            result[0] = result[1] = -1;
            return result;
        }

        return result;
    }
    *
    * */

}
