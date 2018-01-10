package code.lint.two.binarySearch;

/**
 * Created by 505007855 on 9/14/2017.
 */
public class MaximumNumberInMountainSequence {

    /**
     * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

     Have you met this question in a real interview? Yes
     Example
     Given nums = [1, 2, 4, 8, 6, 3] return 8
     Given nums = [10, 9, 8, 7], return 10
     *
     * */

    public static void main(String[] args){

     //   int[] nums = {1, 2, 4, 8, 6, 3};
        int[] nums = {10, 9, 8, 7};

        int result = mountainSequence(nums);

        System.out.println("Result is: " + result);

    }

    public static int mountainSequence(int[] nums) {

    /*   // Basic way

     int max = 0;

        if(nums == null || nums.length == 0){
            return -1;
        }

        for(int i = 0; i < nums.length; i++){

            if (nums[i] > max){
                max = nums[i];
            }

        }

        return max; */



        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length -1;
        int mid = 0;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid +1]){
                start = mid;
            }else if(nums[mid] > nums[mid + 1]){
                end = mid;
            }else{
                return nums[mid];
            }

        }

        if(nums[start] > nums[end]){
            return nums[start];
        }else{
            return nums[end];
        }
    }

/* Jiu Zhang's answer */

    // version 1：二分法
    public static int mountainSequence0(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }

    // version 2: 一个比较啰嗦的版本，本质也是2分法，每次取两个点
    public int mountainSequence1(int[] nums) {
            // Write your code here
            int left = 0, right = nums.length - 1;
            while (left + 1 < right) {
                int m1 = left + (right - left) / 2;
                int m2 = right - (right - m1) / 2;
                if (nums[m1] < nums[m2]) {
                    left = m1 + 1;
                } else if (nums[m1] > nums[m2]) {
                    right = m2 - 1;
                } else {
                    left = m1;
                    right = m2;
                }
            }
            return nums[left] > nums[right] ? nums[left] : nums[right];
        }


    /* Shuo Chang's Answer */

    public int mountainSequence2(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]){
                end = mid;
            } else if (nums[mid] < nums[mid + 1]){
                start = mid;
            } else {
                return mid;
            }
        }
        if (nums[start] > nums[end]){
            return nums[start];
        }
        return nums[end];
    }


}
