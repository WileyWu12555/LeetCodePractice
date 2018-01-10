package code.lint.two.binarySearch;


/*
*
* There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

 Notice

It's guaranteed the array has at least one peak.
The array may contain multiple peeks, find any of them.
The array has at least 3 numbers in it.
Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)

Challenge
Time complexity O(logN)

你给出一个整数数组(size为n)，其具有以下特点：

相邻位置的数字是不同的
A[0] < A[1] 并且 A[n - 2] > A[n - 1]
假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置
*
* */

public class FindPeakElement {

    /*
    * @param A: An integers array.
    * @return: return any of peek positions.
    */
    public int findPeak(int[] A) {
        // write your code here

        if(A == null || A.length < 3){
            return -1;
        }

        int start = 1;
        int end = A.length - 2;

        while(start + 1 < end ){
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]){
                end = mid;
            }else if(A[mid] < A[mid + 1]){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(A[start] < A[end]){
            return end;
        }else{
            return start;
        }

    }

    // Jiu Zhang's Answer

    /*
    *
    *public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
    *
    * */

    // Shuo Chang's Answer
    /*
    *
    *  public int findPeak(int[] A) {
        if (A == null || A.length == 0){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (A[mid] > A[mid + 1]){
                end = mid;
            } else if (A[mid] < A[mid + 1]){
                start = mid;
            } else if (A[mid + 1] < A[mid] && A[mid - 1] < A[mid]){
                return mid;
            }
        }
        if (A[start] < A[end]){
            return end;
        }
        return start;
    }
    *
    * */
}
