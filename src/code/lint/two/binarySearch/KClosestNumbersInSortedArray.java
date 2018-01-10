package code.lint.two.binarySearch;


/*
* Given a target number, a non-negative integer k and an integer array A sorted in ascending order,
 * find the k closest numbers to target in A,
 * sorted in ascending order by the difference between the number and target.
 * Otherwise, sorted in ascending order by number if the difference is same.

Have you met this question in a real interview? Yes
Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

Challenge
O(logn + k) time complexity.

给一个目标数 target, 一个非负整数 k,
一个按照升序排列的数组 A。在A中找与target最接近的k个整数。
返回这k个数并按照与target的接近程度从小到大排序，如果接近程度相当，那么小的数排在前面。

*
* */
public class KClosestNumbersInSortedArray {

    /*
        * @param A: an integer array
        * @param target: An integer
        * @param k: An integer
        * @return: an integer array
        */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here

        int[] result = new int[k];

        if(A == null || A.length == 0){
            return null;
        }

        if(k > A.length){
            return A;
        }

        int firstIndex = firstIndex(A, target);

        int start = firstIndex - 1;
        int end = firstIndex;

        for(int i = 0; i < k; i++){
            if(start < 0){
                result[i] = A[end++];
            } else if(end >= A.length){
                result[i] = A[start--];
            }else{
                if(target - A[start] <= A[end] - target){
                    result[i] = A[start--];
                }else{
                    result[i] = A[end++];
                }
            }
        }

        return result;
    }

    public int firstIndex(int[] A, int target){

        int start = 0;
        int end = A.length -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;

            if(A[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(A[start] >= target){
            return start;
        }

        if(A[end] >= target){
            return end;
        }

        return A.length;
    }



    /*
     // Jiu Zhang's Answer

      public int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];

        if (A == null || A.length == 0) {
            return A;
        }
        if (k > A.length) {
            return A;
        }

        int index = firstIndex(A, target);

        int start = index - 1;
        int end = index;
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                result[i] = A[end++];
            } else if (end >= A.length) {
                result[i] = A[start--];
            } else {
                if (target - A[start] <= A[end] - target) {
                    result[i] = A[start--];
                } else {
                    result[i] = A[end++];
                }
            }
        }
        return result;
    }

    private int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }

    * */


/*
// Shuo Chang's Answer

public int[] kClosestNumbers(int[] A, int target, int k) {
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        int[] result = new int[3];
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (A[mid] < target) {
               start = mid;
            } else if (A[mid] > target){
                end = mid;
            } else if (A[mid] == target){
                 start = mid;
            }
        }

        for (int i = 0; i < k; i ++){
           int startdiff = start >= 0 ? Math.abs(A[start] - target) : Integer.MAX_VALUE;
           int enddiff = (end <= A.length - 1) ? Math.abs(A[end] - target) : Integer.MAX_VALUE;
           if (startdiff < enddiff){
               result[i] = A[start];
               start--;
           } else if (startdiff > enddiff){
               result[i] = A[end];
               end++;
           } else if (startdiff == enddiff){
               result[i] = A[start];
               start--;
           }
        }
        return result;
    }


* */

}
