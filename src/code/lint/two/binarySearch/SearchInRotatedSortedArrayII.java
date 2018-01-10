package code.lint.two.binarySearch;


/*
*
*  Follow up for Search in Rotated Sorted Array:

What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

Have you met this question in a real interview? Yes
Example
Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
Given [1, 1, 1, 1, 1, 1] and target = 0, return false.

跟进“搜索旋转排序数组”，假如有重复元素又将如何？

是否会影响运行时间复杂度？

如何影响？

为何会影响？

写出一个函数判断给定的目标值是否出现在数组中。

*
* */


public class SearchInRotatedSortedArrayII {


    /*
    * @param A: an integer ratated sorted array and duplicates are allowed
    * @param target: An integer
    * @return: a boolean
    */
    public boolean search(int[] A, int target) {
        // write your code here

        if(A== null || A.length == 0){
            return false;
        }

        for(int i = 0; i < A.length; i++){
            if(A[i] == target){
                return true;
            }
        }

        return false;

    }

    // Jiu Zhang's Answer
    /**

     public boolean search(int[] A, int target) {
     for (int i = 0; i < A.length; i ++) {
     if (A[i] == target) {
     return true;
     }
     }
     return false;
     }

     * */

    //Shuo Chang's Answer
    /*
    *
    *  public boolean search(int[] A, int target) {
        if (A == null || A.length == 0){
            return false;
        }
        for (int i = 0; i < A.length ; i++){
            if (A[i] == target){
                return true;
            }
        }
        return false;
    }
    *
    * */
}
