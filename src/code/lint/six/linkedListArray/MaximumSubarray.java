package code.lint.six.linkedListArray;


public class MaximumSubarray {
    /*
    *
    * Given an array of integers, find a contiguous subarray which has the largest sum.

 Notice

The subarray should contain at least one number.

Have you met this question in a real interview? Yes
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
    *
    * */


    public int maxSubArray(int[] nums) {

        if(nums == null){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);

        }

        return max;
    }

    /*
    * @param nums: A list of integers
    * @return: A integer indicate the sum of max subarray
    */
   /* public int maxSubArray(int[] nums) {
        // write your code here

        if(nums == null){
            return Integer.MIN_VALUE;
        }

        int len = 0;


        for(int i = 0; i < nums.length; i++){
            len += i;
        }

        int[] subSum = new int[len];

        int[] subArray = new int[nums.length];

        int index = 0;

        for(int j = index; j < nums.length; j++){

            subArray[j] = nums[j];

            subSum[j] = subSum(index, subArray);

        }



        
    }


    public int subSum(int index, int[] nums){

        int sum = 0;

        for (int i = 0; i < index; i++){
            sum += nums[i];
        }

        return sum;

    }

*/


    // JIU ZHANG's Answer

    /*
    *
    *
    // Version 1: Greedy

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}

// Version 2: Prefix Sum

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}



public class Solution {
    //
    // @param nums: a list of integers
    // @return: A integer indicate the sum of minimum subarray
    //
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] global = new int[2];
        int[] local = new int[2];
        global[0] = nums[0];
        local[0] = nums[0];
        for(int i = 1; i < n; i ++) {
            local[i % 2] = Math.max(nums[i], local[(i - 1) % 2] + nums[i]);
            global[i % 2] = Math.max(local[i % 2], global[(i - 1) % 2]);
        }
        return global[(n-1) % 2];
    }
}
    *
    * */


    // Shuo Chang's Answer

    /*
    *
    * public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int max = Integer.MIN_VALUE;
        int min = 0;
        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
            max = Math.max(max, sum[i] - min);
            min = Math.min(min, sum[i]);
        }
        return max;
    }
    *
    * */


}
