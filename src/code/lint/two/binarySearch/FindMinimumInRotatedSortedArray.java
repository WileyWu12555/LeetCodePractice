package code.lint.two.binarySearch;

/**
 * Created by 505007855 on 9/15/2017.
 */
public class FindMinimumInRotatedSortedArray {

    /**
     *
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     Find the minimum element.

     Notice

     You may assume no duplicate exists in the array.

     Have you met this question in a real interview? Yes
     Example
     Given [4, 5, 6, 7, 0, 1, 2] return 0
     *
     * */


    public static void main(String[] args){

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int result = findMin(nums);

        System.out.println("Result is: " + result);

    }



    /* Shuo Chang's Answer */

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return - 1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                start = mid;
            } else {
                if (nums[mid] < nums[mid - 1]){
                    return nums[mid];
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] > nums[end]){
            return nums[end];
        }
        return nums[start];
    }

}
