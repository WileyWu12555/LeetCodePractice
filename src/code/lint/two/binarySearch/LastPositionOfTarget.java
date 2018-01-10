package code.lint.two.binarySearch;

/**
 * Created by 505007855 on 9/13/2017.
 */
public class LastPositionOfTarget {

    /*
    * Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 2.

For target = 5, return 5.

For target = 6, return -1.
    * */

    public static void main(String[] args){

        int[] nums = {1, 2, 2, 4, 5, 5};
        int target = 5;

        int result = getLastPosition(nums, target);

        System.out.println("Result is: " + result);

    }

    public static int getLastPosition(int[] nums, int target){

        if(nums == null || nums.length == 0){
            return -1;
        }

        int index = lastIndex(nums, target);

        return index;
    }

    public static int lastIndex(int[] nums, int target){

        int start = 0, end = nums.length - 1;


        while(end - 1 > start){

            int mid = start + (end - start) / 2;

            if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] <= target){
                start = mid;
            }
        }

        if(nums[end] == target){
            return end;
        }

        if(nums[start] == target ){
            return start;
        }

        return -1;
    }







    /* Shuo Chang's Answer */

    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target){
            return end;
        }

        if (nums[start] == target){
            return start;
        }
        return -1;
    }




}
