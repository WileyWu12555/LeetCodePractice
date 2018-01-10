package code.lint.two.binarySearch;

/*
*
* Given a target number and an integer array sorted in ascending order.
* Find the total number of occurrences of target in the array.

Have you met this question in a real interview? Yes
Example
Given [1, 3, 3, 4, 5] and target = 3, return 2.

Given [2, 2, 3, 4, 6] and target = 4, return 1.

Given [1, 2, 3, 4, 5] and target = 6, return 0.

Challenge
Time complexity in O(logn)

给一个升序的数组，以及一个target，找到它在数组中出现的次数。

*
* */
public class TotalOccurrenceOfTarget {

    /*
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here


        if(A == null || A.length == 0){
            return 0;
        }

        int n = A.length;
        if(A[n-1] < target || target < A[0]){
            return 0;
        }

    /*    int start = 0;
        int end = n - 1;
        int mid = 0;

        while (start + 1 < end){
            mid = start + (end - start) / 2;

            if(A[start] <= target){
                start = mid;
            }

            if( A[end] >= target){
                end = mid;
            }
        }

        if(A[start] == target && A[end] == target){
            return end - start;
        }

        return 0;*/

    int start = 0;
    int end = n - 1;
    int begin = 0;

    while (start <= end){

        int mid = start + (end - start) / 2;
        if(A[mid] >= target){
            begin = mid;
            end = mid - 1;
        }else{
            start = mid + 1;
        }
    }

    if(A[begin] != target){
            return 0;
    }

    int start1 = 0;
    int end1 = n - 1;
    int last = n - 1;

    while(start1 <= end1){
        int mid = start1 + (end1 - start1) / 2;
        if(A[mid] <= target){
            last = mid;
            start1 = mid + 1;
        }else{
            end1 = mid - 1;
        }
    }

    return last - begin + 1;

  }

    // Jiu Zhang's Answer
    /*
    *
    * public int totalOccurrence(int[] A, int target) {
        // Write your code here
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        if (A[n-1] < target || A[0] > target) {
            return 0;
        }

        int l = 0, r = n - 1;
        int start = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] >= target) {
                start = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        if (A[start] != target)
            return 0;

        int end = n - 1;
        l = 0; r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] <= target) {
                end = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return end - start + 1;
    }
    *
    * */

    // Shuo Chang's Answer
    /*
    *
    *  public int totalOccurrence(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int startIndex = 0;
        int endIndex = 0;
        if(A == null || A.length ==0){
            return 0;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target){
                start = mid;
            } else if (A[mid] > target){
                end = mid;
            } else if (A[mid] == target){
                end = mid;
            }
        }
        if (A[start] == target){
            startIndex = start;
        } else if (A[start] != target && A[end] == target){
            startIndex = end;
        } else {
            return 0;
        }


        start = 0;
        end = A.length - 1;
         while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target){
                start = mid;
            } else if (A[mid] > target){
                end = mid;
            } else if (A[mid] == target){
                start = mid;
            }
        }
        if (A[end] == target){
            endIndex = end;
        } else if (A[end] != target && A[start] == target){
            endIndex = start;
        }

        return endIndex - startIndex + 1;
    }
    *
    * */

}
