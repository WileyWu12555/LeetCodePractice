package code.lint.two.binarySearch;


import java.util.Arrays;

/*
*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

 Notice

The array may contain duplicates.

Have you met this question in a real interview? Yes
Example
Given [4,4,5,6,7,0,1,2] return 0.

  0 1  2  3  4  5  6 7  8  9   10  11  12  13  14
  8 9 10 11 12 13 14  0  1  2   3   4   5   6   7

假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。

你需要找到其中最小的元素。

数组中可能存在重复的元素

*
* */
public class FindMinimumInRotatedSortedArrayII {

    /*
   * @param nums: a rotated sorted array
   * @return: the minimum number in the array
   */
 /*   public int findMin(int[] nums) {
        // write your code here

        if(nums == null || nums.length == 0){
            return -1;
        }

        Arrays.sort(nums);

        return nums[0];

    }*/

    public int findMin(int[] nums) {
        // write your code here

        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == nums[end]){
                end--;
            }else if (nums[mid] < nums[end]){
                end = mid;
            }else {
                start = mid;
            }
        }

        if(nums[start] <= nums[end]){
            return nums[start];
        }

        return nums[end];
    }


    // Jiu Zhang's answer

    /**

    // Methdo 1

     public int findMin(int[] num) {
     //  这道题目在面试中不会让写完整的程序
     //  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
     //  这种情况使得时间复杂度必须是 O(n)
     //  因此写一个for循环就好了。
     //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
     //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
     int min = num[0];
     for (int i = 1; i < num.length; i++) {
     if (num[i] < min)
     min = num[i];
     }
     return min;
     }


     // Method 2

     public int findMin(int[] nums) {
     if (nums == null || nums.length == 0) {
     return -1;
     }

     int start = 0, end = nums.length - 1;
     while (start + 1 < end) {
     int mid = start + (end - start) / 2;
     if (nums[mid] == nums[end]) {
     // if mid equals to end, that means it's fine to remove end
     // the smallest element won't be removed
     end--;
     } else if (nums[mid] < nums[end]) {
     end = mid;
     // of course you can merge == & <
     } else {
     start = mid;
     // or start = mid + 1
     }
     }

     if (nums[start] <= nums[end]) {
     return nums[start];
     }
     return nums[end];
     }

     */

    //Shuo Chang's Answer
    /*

     public int findMin(int[] num) {

        if (num == null || num.length == 0){
            return -1;
        }
        int min = num[0];
        for (int i = 0; i < num.length ; i++){
            if(min > num[i]){
                return min = num[i];
            }
        }
      return min;
    }

    * */



}
