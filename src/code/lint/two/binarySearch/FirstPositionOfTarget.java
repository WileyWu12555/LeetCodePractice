package code.lint.two.binarySearch;

/*
*
* For a given sorted array (ascending order) and a target number,
* find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Have you met this question in a real interview? Yes
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

Challenge
If the count of numbers is bigger than 2^32, can your code work properly?

给定一个排序的整数数组（升序）和一个要查找的整数target，
用O(logn)的时间查找到target第一次出现的下标（从0开始），
如果target不存在于数组中，返回-1。
*
* */

public class FirstPositionOfTarget {

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here

        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start + 1< end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            } else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }

        return -1;

    }

    // Jiu Zhang's Answer
    /*
    *
    // version 1: with jiuzhang template
     public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or end = mid - 1
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }


    // version 2: without jiuzhang template

        public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
    *
    * */

    // Shuo Chang's Answer
    /*
    *
    * public int binarySearch(int[] nums, int target) {
        //write your code here

          if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;

            if(nums[start] == target){
                return start;
            }

            if(nums[mid] >= target){
                end = mid;
            }else {
                start = mid;
            }

        }

        if(nums[start] == target){
            return start;
        }

        if(nums[end] == target){
            return end;
        }


        return -1;

    }
    *
    * */
}
