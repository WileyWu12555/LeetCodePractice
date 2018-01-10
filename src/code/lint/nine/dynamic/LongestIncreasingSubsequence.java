package code.lint.nine.dynamic;

/*
*
* Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Have you met this question in a real interview? Yes
Clarification
What's the definition of longest increasing subsequence?

The longest increasing subsequence problem is to find a subsequence
of a given sequence in which the subsequence's elements are
in sorted order, lowest to highest, and in which the subsequence is
as long as possible. This subsequence is not necessarily
contiguous, or unique.

https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

Challenge
Time complexity O(n^2) or O(nlogn)
*
* */

public class LongestIncreasingSubsequence {

    /*
   * @param nums: An integer array
   * @return: The length of LIS (longest increasing subsequence)
   */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here

        int[] f = new int[nums.length];

        int max = 0;

        for(int i = 0; i < nums.length; i++){
            f[i] = 1;

            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
            
            if(f[i] > max){
                max = f[i];
            }
        }

        return max;

    }


    // JIU Zhang's Answer

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */

    /*
    public int longestIncreasingSubsequence(int[] nums) {
        int []f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }

*/

    // O(nlogn) Binary Search

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
   /* public int longestIncreasingSubsequence(int[] nums) {
        int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            // find the first number in minLast >= nums[i]
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }

        for (int i = nums.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }

        return 0;
    }

    // find the first number > num
    private int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }

    */


    // Shuo Chang's Answer

    /*public class Solution {

    public int longestIncreasingSubsequence(int[] nums) {
          if (nums == null || nums.length == 0){
            return 0;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            result[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++){
            int index = binarySearch(result, nums[i]);
            result[index] = nums[i];
        }

        for (int i = result.length - 1; i >= 0; i--){
            if (result[i] < Integer.MAX_VALUE){
                return i + 1;
            }
        }
        return 0;
    }

    public int binarySearch(int[] result, int target){
        int start = 0;
        int end = result.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (result[mid] < target){
                start = mid;
            } else if (result[mid] > target){
                end = mid;
            } else {
                end = mid;
            }
        }
        if (result[start] >= target){
            return start;
        }
        return end;
    }
}
*/

    /*
    *
    *  public int longestIncreasingSubsequence(int[] nums) {

         //dp[] 到当前位置的最长LIS
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(dp[i], max);
        }
        return max;
     }
    *
    * */
}
